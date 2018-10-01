LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI += "\
        file://static-link.c\
        file://static-link.h\
"


do_configure() {
        cp -f ${WORKDIR}/static-link.* ${S}
}
 
do_compile() {
        ${CC} -c -o static-link.o static-link.c
        ${AR} rcs libstatic-link.a static-link.o
}
 
do_install() {
	mkdir -p ${D}${libdir}/ ${D}${includedir}/
        cp ${S}/libstatic-link.a ${D}${libdir}/
        cp ${S}/static-link.h ${D}${includedir}/
}


