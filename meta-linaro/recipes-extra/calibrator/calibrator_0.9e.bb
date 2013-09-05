SUMMARY = "Cache-Memory and TLB calibration tool"
DESCRIPTION = "The Calibrator is a small C program that is supposed to \
analyze a computers (cache-) memory system and extract the following \
parameters: \
number of cache levels, main memory access latency, number of TLB levels."
HOMEPAGE = "http://homepages.cwi.nl/~manegold/Calibrator/"
SECTION = "console/tools"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://calibrator.c;endline=39;md5=102be98d5b443582cffa8eb4ee776af8"
PR = "r0"

SRC_URI = "http://homepages.cwi.nl/~manegold/Calibrator/src/calibrator.c \
    file://fix_conflicting_types_for_round.patch"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} calibrator.c -o calibrator -lm
}

do_install() {
    install -D -p -m0755 calibrator ${D}${bindir}/calibrator
}

COMPATIBLE_HOST = "(i.86|x86_64|arm|aarch64).*-linux"
