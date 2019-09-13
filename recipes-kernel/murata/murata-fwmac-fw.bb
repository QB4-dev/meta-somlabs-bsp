DESCRIPTION = "Murata firmware"
LICENSE = "commercial"
LIC_FILES_CHKSUM = "file://LICENCE.cypress;md5=cbc5f665d04f741f1e006d2096236ba7"

SRC_URI = "\
	git://github.com/murata-wireless/cyw-fmac-fw.git \
"

S = "${WORKDIR}/git"

SRCREV = "8d87950bfad28c65926695b7357bd8995b60016a"

do_install () {
	install -d ${D}${base_libdir}/firmware/brcm
	install -m 0644 ${WORKDIR}/git/brcmfmac43430-sdio.bin ${D}${base_libdir}/firmware/brcm/brcmfmac43430-sdio.bin
	install -m 0644 ${WORKDIR}/git/brcmfmac43430-sdio.1DX.clm_blob ${D}${base_libdir}/firmware/brcm/brcmfmac43430-sdio.clm_blob
}

FILES_${PN} += "${base_libdir}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
#COMPATIBLE_MACHINE = "visionsom6ull"

RDEPENDS_${PN} += "murata-fwmac-nvram"

