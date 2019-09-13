LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DESCRIPTION = "i.MX U-Boot suppporting SoMLabs boards."
require recipes-bsp/u-boot/u-boot.inc

PV = "2018.09"
PR = "r0"

PROVIDES += "u-boot"

UBOOT_LOCALVERSION = "-somlabs"

SRCREV = "2b9de64f7876357840fb1471dc10eea5fffb9b9a"
SRC_URI = "git://github.com/marcinbis/somlabs-uboot-imx.git;branch=${PV};protocol=git"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|use-mainline-bsp)"

DEPENDS += "bison-native"

# Set default device tree file names
do_setfdtfile () {
    DEFAULT_DT=$(echo ${KERNEL_DEVICETREE} | cut -d ' ' -f1)
    DEFAULT_NAND_DT=$(echo ${KERNEL_DEVICETREE} | grep -o '\S*-nand\S*' | head -1)

    sed -i "s/fdt_file=somlabs-visionsom-6ull.dtb/fdt_file=${DEFAULT_DT}/g"           ${WORKDIR}/git/include/configs/somlabs_visionsom_6ull.h
    sed -i "s/fdt_file=somlabs-visionsom-6ull-nand.dtb/fdt_file=${DEFAULT_NAND_DT}/g" ${WORKDIR}/git/include/configs/somlabs_visionsom_6ull.h
}
addtask do_setfdtfile after do_unpack before do_patch
