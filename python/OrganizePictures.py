import os
import shutil
from datetime import datetime
from PIL import Image

# Set the source and destination directories
src_dir = "/Volumes/homes/ftp_user/"
dst_dir = "/Volumes/homes/ftp_user/dated/"


def get_file_seq_no(file_name):
    return int(file_name.split('.')[0].replace('YHPG',''))


# Loop through all the files in the source directory
for filename in os.listdir(src_dir):
    # if get_file_seq_no(file_name=filename) < 5107:
    #     continue
    # Get the full path of the file
    file_path = os.path.join(src_dir, filename)
    # if "dated" in file_path:
    #     continue
    # Check if the file is an image file
    if filename.endswith(".jpg") or filename.endswith(".JPG"):
        # Open the image file using PIL
        with Image.open(file_path) as img:
            # Get the exif data
            exif_data = img._getexif()

            # Check if the exif data contains the date taken field
            if exif_data and 36867 in exif_data:
                # Get the date taken from the exif data
                date_taken_str = exif_data[36867]
                date_taken = datetime.strptime(date_taken_str, '%Y:%m:%d %H:%M:%S')

                # Create the destination directory based on the date taken
                year = date_taken.strftime('%Y')
                month = date_taken.strftime('%m')
                day = date_taken.strftime('%d')
                dst_subdir = os.path.join(dst_dir, year, month, day)

                # Create the destination directory if it doesn't exist
                os.makedirs(dst_subdir, exist_ok=True)

                # Move the file to the destination directory
                shutil.move(file_path, os.path.join(dst_subdir, filename))

                print(f"{file_path} is moved to {dst_subdir}")
