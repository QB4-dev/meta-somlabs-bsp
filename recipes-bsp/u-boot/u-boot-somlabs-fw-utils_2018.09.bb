# Copyright (C) 2019 SoMLabs
SUMMARY = "U-Boot bootloader fw_printenv/setenv utilities"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DESCRIPTION = "i.MX U-Boot suppporting SoMLabs boards."
inherit uboot-config

PV = "2018.09"
PR = "r0"

UBOOT_LOCALVERSION = "-somlabs"

SRCREV = "2b9de64f7876357840fb1471dc10eea5fffb9b9a"
SRC_URI = " \
	git://github.com/marcinbis/somlabs-uboot-imx.git;branch=${PV};protocol=git \
	file://fw_env.config \
"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|use-mainline-bsp)"

INSANE_SKIP_${PN} = "already-stripped"
EXTRA_OEMAKE_class-target = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" V=1'
EXTRA_OEMAKE_class-cross = 'HOSTCC="${CC} ${CFLAGS} ${LDFLAGS}" V=1'

inherit uboot-config

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake envtools
}

do_install () {
	install -d ${D}${base_sbindir}
	install -d ${D}${sysconfdir}
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
	install -m 0644 ${WORKDIR}/fw_env.config  ${D}${sysconfdir}/fw_env.config

	#Make swupdate happy
	install -d ${D}${libdir}
	install -m 644  ${S}/tools/env/lib.a ${D}${libdir}/libubootenv.a
}

do_install_class-cross () {
	install -d ${D}${bindir_cross}
	install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_setenv
}

SYSROOT_DIRS_append_class-cross = " ${bindir_cross}"
DEPENDS += "bison-native"

BBCLASSEXTEND = "cross"

PROVIDES += "u-boot-fw-utils"
RPROVIDES_${PN} += "u-boot-fw-utils"

