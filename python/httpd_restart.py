import logging
import os
import subprocess
import time

import requests

logging.basicConfig(level=logging.INFO,
                    format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger()

# Replace with your values
wordpress_url = 'https://www.yuhongphotography.com/'

# Set the maximum number of retries
max_retries = 3

# Set the retry interval in seconds
retry_interval = 10


# Check if the WordPress website is accessible
def is_wordpress_accessible():
    try:
        response = requests.get(wordpress_url)
        return response.status_code == 200
    except:
        return False


def restart_httpd():
    try:
        result = subprocess.run(["sudo", "systemctl", "restart", "httpd"], check=True)
        if result.returncode == 0:
            logger.info("Apache HTTPD restarted successfully.")
        else:
            logger.info("Error restarting Apache HTTPD:", result.returncode)
    except subprocess.CalledProcessError as e:
        logger.info("Error restarting Apache HTTPD:", e)


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
    file_path = "./processing.lock"
    try:
        retries = 0
        while not is_wordpress_accessible() and retries < max_retries:
            if retries > 0:
                logger.info('Retrying in {} seconds...'.format(retry_interval))
                time.sleep(retry_interval)
            if file_exists(file_path):
                logger.info("A process is already running")
                exit(0)
            else:
                create_file(file_path)
            logger.info('WordPress website is not accessible. Restarting httpd service')
            try:
                restart_httpd()
            except Exception as e:
                logger.error(e)
                exit(1)
            retries += 1
        if is_wordpress_accessible():
            logger.info('WordPress website is accessible.')
            exit(0)
        else:
            logger.info('Failed to access WordPress website after {} retries. Exiting...'.format(retries))
    finally:
        delete_file(file_path)


if __name__ == '__main__':
    main()