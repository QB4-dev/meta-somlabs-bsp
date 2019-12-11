# Image types add UBIimage type for NAND boards
IMAGE_FSTYPES += "ubi"

UBI_VOLNAME = "rootfs"

# UBI settings for 256MB NAND
#MKUBIFS_ARGS = "-F -m 2048 -e 126976 -c 5600"
#UBINIZE_ARGS = "-m 2048 -p 128KiB -s 512 -O 2048"


# UBI settings for 512MB NAND
MKUBIFS_ARGS = "-F -m 4096 -e 253952 -c 2650"
UBINIZE_ARGS = "-m 4096 -p 256KiB -s 4096 -O 4096"
