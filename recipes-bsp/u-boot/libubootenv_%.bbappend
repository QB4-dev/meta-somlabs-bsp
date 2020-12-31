# Custom of fw-env.config
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Sources
SRC_URI_append = " \
    file://fw_env.config \
"
do_install_append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fw_env.config  ${D}${sysconfdir}/fw_env.config
}
