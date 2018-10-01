LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
# comment...
INSANE_SKIP_${PN} = "ldflags"

DEPENDS = "test1-static-link"
SRC_URI += "\
        file://main.c"

do_configure() {
	cp -f ${WORKDIR}/main.c ${S}
}

do_compile() {
        ${CC} -c -o main.o main.c 
# ${STAGING_DIR_TARGET}/${libdir}/libstatic-link.a
        ${CC} -o main main.o -lstatic-link
}

do_install() {
	mkdir -p ${D}${bindir}/
        cp ${S}/main ${D}${bindir}/
}


