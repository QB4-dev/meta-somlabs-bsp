FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
        file://0001-add-missing-pxp-node.patch \
        file://visionsom-6ull.dtsi \ 
        file://visionsom-6ull-wifibt.dtsi \ 
        file://visionsom-6ull-nand.dtsi \ 
        file://visionsom-6ull-nand-wifi.dtsi \
        file://visionsom-6ull-emmc.dtsi \
        file://visionsom-6ull-emmc-wifi.dtsi \
        file://visionsom-6ull-sd.dtsi \
        file://visionsom-6ull-sd-wifi.dtsi \ 
        file://visioncb-std.dtsi \         
        file://visioncb-std-visionsom-6ull-nand.dts \ 
        file://visioncb-std-visionsom-6ull-nand-wifi.dts \ 
        file://visioncb-std-visionsom-6ull-emmc.dts \ 
        file://visioncb-std-visionsom-6ull-emmc-wifi.dts \
        file://visioncb-std-visionsom-6ull-sd.dts \ 
        file://visioncb-std-visionsom-6ull-sd-wifi.dts \           
"

do_compile_prepend () {
        cp ${WORKDIR}/*.dts  ${S}/arch/${ARCH}/boot/dts
        cp ${WORKDIR}/*.dtsi ${S}/arch/${ARCH}/boot/dts
}
