DESCRIPTION = "Murata firmware nvram"
LICENSE = "commercial"
LIC_FILES_CHKSUM = "file://LICENCE.cypress;md5=cbc5f665d04f741f1e006d2096236ba7"

SRC_URI = "\
	git://github.com/murata-wireless/cyw-fmac-nvram.git \
"

S = "${WORKDIR}/git"

SRCREV = "d27f1bf105fa1e5b828e355793b88d4b66188411"

do_install () {
	install -d ${D}${base_libdir}/firmware/brcm
	install -m 0644 ${WORKDIR}/git/brcmfmac43430-sdio.1DX.txt ${D}${base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt
}

FILES_${PN} += "${base_libdir}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
#COMPATIBLE_MACHINE = "visionsom6ull"
