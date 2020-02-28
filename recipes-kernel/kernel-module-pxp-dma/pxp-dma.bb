SUMMARY = "PXP DMA driver ported from -imx kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"
COMPATIBLE_MACHINE = "(mx6ul|mx6ull)"

inherit module

SRC_URI = " \
   file://COPYING            \
   file://Makefile           \
   file://pxp_device.c       \
   file://pxp_dma_v3.c       \
   file://regs-pxp_v3.h      \ 
   file://reg_bitfields.h    \
   file://linux/pxp_device.h \
   file://linux/pxp_dma.h    \
   file://linux/imx-pxp.h    \
   file://linux/platform_data/dma-imx.h \
   file://uapi/linux/pxp_device.h  \
   file://uapi/linux/pxp_dma.h     \
"

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} += "kernel-module-pxp-dma"

