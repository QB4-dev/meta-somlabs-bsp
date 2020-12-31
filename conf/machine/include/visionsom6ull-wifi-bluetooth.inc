# Murata Wifi + Bluetooth 1DX module support

# add machine features
MACHINE_FEATURES += "wifi bluetooth"

#Firmware for Murata Wi-Fi module + software utils
IMAGE_INSTALL_append = "\
    linux-firmware-bcm43430 \
    linux-firmware-bcm43430a1-hcd \
    packagegroup-base-wifi \
    packagegroup-base-bluetooth \
"

