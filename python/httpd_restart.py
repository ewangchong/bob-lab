import logging
import os
import subprocess
import time

import requests


logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

# Replace with your values
wordpress_url = 'https://www.yuhongphotography.com/'

# Set the maximum number of retries
MAX_RETRIES = 3

# Set the retry interval in seconds
RETRY_INTERVAL = 10


# Check if the WordPress website is accessible
def is_wordpress_accessible():
    try:
        response = requests.get(wordpress_url)
        return response.status_code == 200
    except requests.exceptions.RequestException:
        return False


def restart_httpd():
    try:
        if subprocess.run(["sudo", "systemctl", "restart", "httpd"], check=True).returncode == 0:
            logging.info("Apache HTTPD restarted successfully.")
        else:
            logging.info("Error restarting Apache HTTPD.")
    except subprocess.CalledProcessError as e:
        logging.error(f"Error restarting Apache HTTPD: {e}")


def file_exists(file_path):
    return os.path.isfile(file_path)


def create_file(file_path):
    with open(file_path, "w") as f:
        pass  # An empty context will create an empty file.
    logging.info(f'File {file_path} created')


def delete_file(file_path):
    if file_exists(file_path):
        os.remove(file_path)
        logging.info(f'File {file_path} deleted')


# Main function
def main():
    file_path = "./processing.lock"
    try:
        retries = 0
        while not is_wordpress_accessible() and retries < MAX_RETRIES:
            if retries > 0:
                logging.info(f'Retrying in {RETRY_INTERVAL} seconds...')
                time.sleep(RETRY_INTERVAL)
            if file_exists(file_path):
                logging.info("A process is already running")
                exit(0)
            else:
                create_file(file_path)
            logging.info('WordPress website is not accessible. Restarting httpd service')
            try:
                restart_httpd()
            except Exception as e:
                logging.error(e)
                exit(1)
            retries += 1
        if is_wordpress_accessible():
            logging.info('WordPress website is accessible.')
            exit(0)
        else:
            logging.info(f'Failed to access WordPress website after {retries} retries. Exiting...')
    finally:
        delete_file(file_path)


if __name__ == '__main__':
    main()
# ```

# Refactored code:
# - Changed MAX_RETRIES and RETRY_INTERVAL to uppercase
# - Removed logger variable and directly used the logging module
# - Use f-strings for logging
# - Imported the specific exception from the requests library instead of using a bare except statement.
# - Added f-string to logging errors for subprocess
# - Removed unnecessary comments.