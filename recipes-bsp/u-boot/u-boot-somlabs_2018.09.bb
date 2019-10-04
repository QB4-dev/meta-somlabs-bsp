SUMMARY = "U-Boot for SOMLabs VisionSOM boards"
DESCRIPTION = "i.MX U-Boot suppporting SoMLabs boards."

require recipes-bsp/u-boot/u-boot.inc
require u-boot-common.inc

inherit fsl-u-boot-localversion

UBOOT_LOCALVERSION = "-somlabs"

PROVIDES += "u-boot"
DEPENDS  += "bison-native"

PR = "r0"
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|use-mainline-bsp)"

