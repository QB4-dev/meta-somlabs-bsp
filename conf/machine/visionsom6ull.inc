# SoMLabs SLS16 (VisionSOM-6ULL) common board definition file

# Compatibility with mx6 machines
MACHINEOVERRIDES =. "mx6:mx6ull:"

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa7.inc

# u-boot and kernel providers
PREFERRED_PROVIDER_u-boot = "u-boot-somlabs"
PREFERRED_PROVIDER_u-boot-fw-utils = "u-boot-somlabs-fw-utils"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-somlabs"
PREFERRED_PROVIDER_virtual/kernel = "linux-fslc"

# u-boot configurations
UBOOT_CONFIG[sd]   = "somlabs_visionsom_6ull_fastboot_mmc_defconfig"
UBOOT_CONFIG[emmc] = "somlabs_visionsom_6ull_fastboot_mmc_defconfig"
UBOOT_CONFIG[nand] = "somlabs_visionsom_6ull_fastboot_nand_defconfig"

# Always depend of u-boot
EXTRA_IMAGEDEPENDS += "u-boot-somlabs"

SERIAL_CONSOLE = "115200 ttymxc0"

# Add kernel in image
IMAGE_INSTALL_append = " kernel-image kernel-devicetree kernel-modules"

IMAGE_FSTYPES = "wic.gz"

