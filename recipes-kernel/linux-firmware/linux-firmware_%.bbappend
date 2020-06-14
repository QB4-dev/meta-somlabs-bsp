FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://BCM43430A1.hcd"

PACKAGES_prepend = "\
	${PN}-bcm43430a1-hcd \
"

FILES_${PN}-bcm43430a1-hcd = " \
 	${nonarch_base_libdir}/firmware/brcm/BCM43430A1.hcd \
"

LICENSE_${PN}-bcm43430a1-hcd = "Firmware-cypress"


do_install_append() {
	install -d ${D}${nonarch_base_libdir}/firmware/brcm/

	#Add missing Bluetooth firmware files
        install -m 0644 ${WORKDIR}/BCM43430A1.hcd ${D}${nonarch_base_libdir}/firmware/brcm/

	#Link Murata 1DX file as brcmfmac43430-sdio.txt needed by driver
	cd ${D}${nonarch_base_libdir}/firmware/brcm/
	ln -sf  brcmfmac43430-sdio.MUR1DX.txt brcmfmac43430-sdio.txt
}

RDEPENDS_${PN}-bcm43430a1-hcd += "${PN}-cypress-license"
