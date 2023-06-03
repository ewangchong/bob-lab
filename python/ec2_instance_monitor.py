import os
import time
import requests
import boto3
import logging

logging.basicConfig(level=logging.INFO,
                    format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger()

# Replace with your values
wordpress_url = 'https://www.yuhongphotography.com/'
instance_id = 'i-01c39fefb190b0037'
aws_region = 'us-east-1'

# Set the maximum number of retries
max_retries = 3

# Set the retry interval in seconds
retry_interval = 10

# Create a new EC2 client
ec2 = boto3.client('ec2', region_name=aws_region)


# Check if the WordPress website is accessible
def is_wordpress_accessible():
    try:
        response = requests.get(wordpress_url)
        return response.status_code == 200
    except:
        return False


# Stop the EC2 instance
def stop_instance():
    # Check if the EC2 instance is running
    instance_status = ec2.describe_instance_status(
        InstanceIds=[instance_id]
    )
    try:
        instance_state = instance_status['InstanceStatuses'][0]['InstanceState']['Name']
        if instance_state == 'running':
            # Stop the EC2 instance
            ec2.stop_instances(InstanceIds=[instance_id])
            waiter = ec2.get_waiter('instance_stopped')
            waiter.wait(InstanceIds=[instance_id])
            logger.info('EC2 instance stopped')
        else:
            logger.info('EC2 instance is already stopped')
    except Exception as ex:
        logger.info(ex)


# Start the EC2 instance
def start_instance():
    ec2.start_instances(InstanceIds=[instance_id])
    ec2.get_waiter('instance_running').wait(InstanceIds=[instance_id])


def file_exists(file_path):
    return os.path.isfile(file_path)

def create_file(file_path):
    with open(file_path, "w") as f:
        pass  # An empty context will create an empty file.
    logger.info('File {} created'.format(file_path))


def delete_file(file_path):
    if file_exists(file_path):
        os.remove(file_path)
        logger.info('File {} deleted'.format(file_path))


# Main function
def main():
    if is_wordpress_accessible():
        logger.info('WordPress website is accessible.')
        exit(0)

    file_path = "./processing.lock"

    if file_exists(file_path):
        logger.info("A process is already running")
        exit(0)
    else:
        create_file(file_path)

        retries = 0

        while not is_wordpress_accessible() and retries < max_retries:
            logger.info('WordPress website is not accessible. Retrying in {} seconds...'.format(retry_interval))
            time.sleep(retry_interval)
            retries += 1

            if retries == max_retries:
                logger.info(
                    'WordPress website is still not accessible after {} retries. Stopping instance...'.format(
                        max_retries))
                stop_instance()
                logger.info('Instance stopped. Starting instance...')
                start_instance()
                logger.info('Instance started.')
                logger.info('WordPress website is accessible.')

                delete_file(file_path)

if __name__ == '__main__':
    main()
