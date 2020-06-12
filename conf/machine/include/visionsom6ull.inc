# SoMLabs VisionSOM-6ULL common board definition file

# compatibility with mx6 machines
MACHINEOVERRIDES =. "mx6:mx6ul:mx6ull:"
IMX_DEFAULT_BSP = "nxp"

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa7.inc

# u-boot and kernel providers
PREFERRED_PROVIDER_u-boot = "u-boot-somlabs"
PREFERRED_PROVIDER_u-boot-fw-utils = "u-boot-somlabs-fw-utils"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-somlabs"
PREFERRED_PROVIDER_virtual/kernel = "linux-imx"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.16.imx"

SERIAL_CONSOLE = "115200 ttymxc0"

# u-boot configurations
UBOOT_CONFIG[sd]   = "somlabs_visionsom_6ull_fastboot_mmc_defconfig"
UBOOT_CONFIG[emmc] = "somlabs_visionsom_6ull_fastboot_mmc_defconfig"
UBOOT_CONFIG[nand] = "somlabs_visionsom_6ull_fastboot_nand_defconfig"

# always depend of u-boot
EXTRA_IMAGEDEPENDS += "u-boot-somlabs"

# add u-boot utils + kernel to image
IMAGE_INSTALL_append = " \
    kernel-image \
    kernel-devicetree \
    kernel-modules \
    u-boot-splash \
    u-boot-somlabs-fw-utils \
"  

IMAGE_FSTYPES = "wic.gz"

# single partition image
WKS_FILE = "imx-uboot.wks"

