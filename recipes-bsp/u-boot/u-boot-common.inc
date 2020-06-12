SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "somlabs-imx_v2018.03_4.14.98_2.0.0_ga"
SRCREV = "dbe68c464c301ddcd83ca4c09d7bf93baf85ed5e"

SRC_URI = "git://github.com/SoMLabs/somlabs-uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
           file://0001-enabled-saveenv-feature.patch \
           file://0002-init-env-target.patch \
           "

S = "${WORKDIR}/git"

# Set default device tree file names
do_setfdtfile () {
    DEFAULT_DT=$(echo ${KERNEL_DEVICETREE} | cut -d ' ' -f1)

    sed -i "s/somlabs-\${board}\${fdt_suffix}.dtb/${DEFAULT_DT%.*}\${fdt_suffix}.dtb/g"           ${WORKDIR}/git/include/configs/somlabs_visionsom_6ull.h
}

addtask do_setfdtfile after do_unpack before do_patch
