from datetime import datetime

import boto3
import awswrangler as wr

MEMBERSHIP_ID = 'b3b421f3-e485-4b85-943f-1a379eddbfcf'
COLLABORATOR_ID = '368f2f47-c929-4889-821e-5ebee538fac1'

custom_session = boto3.Session(
    aws_profile = 'test',
    region_name='us-east-1'
)

# response = client.list_schemas(
#     collaborationIdentifier=COLLABORATOR_ID,
#     schemaType='TABLE'
# )

sql = """
WITH SessionInfo AS (
    SELECT log_session_token,
        log_client_application_id,
        log_client_id,
        cart_id,
        log_request_id,
        departure_station_code,
        arrival_station_code
    FROM shopcontroller_rp
    LIMIT {}
),
FlightsInfo AS (
    SELECT DISTINCT log_session_token,
        log_client_application_id,
        log_client_id,
        cart_id,
        log_request_id,
        trip_index,
        segment_index,
        origin_station_code,
        destination_station_code,
        marketing_carrier_code,
        operating_carrier_code,
        departure_dtml,
        destination_dtml,
        bbx_hash
    FROM shopcontroller_rp_flights
),
ProductsInfo AS (
    SELECT DISTINCT log_session_token,
        log_client_application_id,
        log_client_id,
        cart_id,
        log_request_id,
        trip_index,
        segment_index,
        product_index,
        product_id,
        product_category,
        product_subtype,
        product_type,
        base_fare_code,
        booking_type_code,
        cabin_type,
        cabin_fare_type,
        product_description,
        bbx_hash
    FROM shopcontroller_rp_flights_products
),
PricesInfo AS (
    SELECT log_session_token,
        log_request_id,
        trip_index,
        segment_index,
        product_index,
        price_index,
        product_id,
        base_fare_code,
        product_amount,
        currency_code,
        bbx_hash,
        displayed_price_type_code
    FROM shopcontroller_rp_flights_products_prices
),
FaresInfo AS (
    SELECT log_session_token,
        cart_id,
        log_request_id,
        trip_index,
        segment_index,
        product_index,
        product_id,
        base_fare_code,
        basic_fare_amount
    FROM shopcontroller_rp_flights_products_fares
)
SELECT A.log_session_token,
    A.log_client_application_id,
    A.log_client_id,
    A.cart_id,
    A.log_request_id,
    A.departure_station_code,
    A.arrival_station_code,
    B.trip_index,
    B.segment_index,
    B.origin_station_code,
    B.destination_station_code,
    B.marketing_carrier_code,
    B.operating_carrier_code,
    B.departure_dtml,
    B.destination_dtml,
    C.product_index,
    C.product_id,
    C.product_category,
    C.product_subtype,
    C.product_type,
    C.base_fare_code,
    C.booking_type_code,
    C.cabin_type,
    C.cabin_fare_type,
    C.product_description,
    D.product_amount,
    D.currency_code,
    E.basic_fare_amount
FROM SessionInfo A
JOIN FlightsInfo B ON A.log_session_token = B.log_session_token
    AND A.log_request_id = B.log_request_id
LEFT JOIN ProductsInfo C ON A.log_session_token = C.log_session_token
    AND A.log_request_id = C.log_request_id
    AND B.trip_index = C.trip_index
    AND B.segment_index = C.segment_index
    AND B.bbx_hash = C.bbx_hash
LEFT JOIN PricesInfo D ON A.log_session_token = D.log_session_token
    AND A.log_request_id = D.log_request_id
    AND B.trip_index = D.trip_index
    AND B.segment_index = D.segment_index
    AND C.product_index = D.product_index
    AND C.product_id = D.product_id
    AND c.base_fare_code = D.base_fare_code
    AND B.bbx_hash = D.bbx_hash
LEFT JOIN FaresInfo E ON A.log_session_token = E.log_session_token
    AND A.log_request_id = E.log_request_id
    AND B.trip_index = E.trip_index
    AND B.segment_index = E.segment_index
    AND C.base_fare_code = E.base_fare_code
    AND C.product_id = E.product_id
    AND C.product_index = E.product_index
    """
i = 10
while i <= 10000:
    start_time = datetime.now()
    print(f"Start at {start_time}")
    sql = sql.format(i)
    # print(sql)
    df = wr.cleanrooms.read_sql_query(sql, membership_id=MEMBERSHIP_ID, output_bucket='atp-cleanroomdata', output_prefix='bob_test', boto3_session=custom_session)
    time_taken = datetime.now() - start_time
    print(f"{i},{df.shape},{time_taken}")
    i = i * 10

# for schema in response['schemaSummaries']:
#     schema_name = schema['name']
    # SELECT *
    # FROM shopselectcontroller_rp
    # WHERE event_dtml >= (SELECT MAX(event_dtml) - INTERVAL '1 hour' FROM shopselectcontroller_rp);
    # sql = f"SELECT * FROM {schema_name} WHERE log_session_token='9334e0be-a9ea-4205-b91c-58114304479c' and log_request_id='1185536313'"
    # print(f"Executing {sql}")
    # start_time = datetime.now()
    # df = wr.cleanrooms.read_sql_query(sql, membership_id=MEMBERSHIP_ID, output_bucket='atp-cleanroomdata', output_prefix='bob_test', boto3_session=custom_session)
    # time_taken = datetime.now() - start_time
    # print(df)
    # print(f"{sql},{df.shape},{time_taken}")
    # print(df.iloc[0, 0])
    # print(df.shape)
    # print(f"{sql},{df.iloc[0, 0]},{time_taken}")

    # if df.iloc[0, 0] > 0:
    #     sql = f"SELECT * FROM {schema_name} WHERE event_dtml >= (SELECT MAX(event_dtml) - INTERVAL '3 hour' FROM {schema_name})"
    #     # print(sql)
    #     start_time = datetime.now()
    #     df = wr.cleanrooms.read_sql_query(sql, membership_id=MEMBERSHIP_ID, output_bucket='atp-cleanroomdata',
    #                                       output_prefix='bob_test', boto3_session=custom_session)
    #     time_taken = datetime.now() - start_time
    #     # print(df.iloc[0, 0])
    #     # print(df.shape)
    #     print(f"{sql},{df.shape},{time_taken}")
