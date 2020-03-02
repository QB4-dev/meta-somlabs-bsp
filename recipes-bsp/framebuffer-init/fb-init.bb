SUMMARY = "wake up framebuffer on system boot"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fb_wakeup.sh"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rcS.d
    install -m 644 ${WORKDIR}/fb_wakeup.sh   ${D}${sysconfdir}/init.d/fb_wakeup.sh
    chmod a+x ${D}${sysconfdir}/init.d/fb_wakeup.sh
    ln -s -r  ${D}${sysconfdir}/init.d/fb_wakeup.sh   ${D}${sysconfdir}/rcS.d/S03framebuffer
}

FILES_${PN} += "/etc"
