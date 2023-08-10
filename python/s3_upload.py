import boto3
import os

def upload_files_to_s3(bucket_name, prefix, local_directory):
    # Initialize S3 client
    s3_client = boto3.client('s3')

    # Walk through the local directory and upload files to S3
    for root, _, files in os.walk(local_directory):
        for file in files:
            local_path = os.path.join(root, file)
            s3_key = os.path.join(prefix, os.path.relpath(local_path, local_directory))

            s3_client.upload_file(local_path, bucket_name, s3_key)
            print(f"Uploaded {local_path} to s3://{bucket_name}/{s3_key}")

# Example usage:
if __name__ == '__main__':
    # Replace with your S3 bucket name, prefix, and local directory path
    bucket_name = 'YOUR_S3_BUCKET_NAME'
    prefix = 'YOUR_PREFIX'
    local_directory = 'LOCAL_DIRECTORY_PATH'

    upload_files_to_s3(bucket_name, prefix, local_directory)
