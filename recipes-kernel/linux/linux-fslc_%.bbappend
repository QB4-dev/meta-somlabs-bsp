FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESEXTRAPATHS_append := "${THISDIR}/device-tree:"

SRC_URI += "\
        file://0001-add-missing-pxp-node.patch \
        file://visionsom6ull-dtsi/ \ 
        file://somlabs-board-dts/  \   
"

do_compile_prepend () {
        cp ${WORKDIR}/visionsom6ull-dtsi/*.dtsi ${S}/arch/${ARCH}/boot/dts

        cp ${WORKDIR}/somlabs-board-dts/*.dtsi ${S}/arch/${ARCH}/boot/dts
	cp ${WORKDIR}/somlabs-board-dts/*.dts  ${S}/arch/${ARCH}/boot/dts
}
