# Murata Wifi + Bluetooth 1DX module support

# add machine features
MACHINE_FEATURES += "wifi bluetooth"

#Firmware for Murata Wi-Fi module + software utils
IMAGE_INSTALL_append = "\
    firmware-imx-brcm \
    murata-fwmac-fw   \
    packagegroup-base-wifi \
    packagegroup-base-bluetooth \
"


