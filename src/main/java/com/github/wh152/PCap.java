package com.github.wh152;

import java.lang.foreign.MemorySegment;

import static org.npcap.pcap_h.*;

class PCap {

    static {
        System.loadLibrary("wpcap");
    }

    static String pcapVersion() {
        MemorySegment version = pcap_lib_version();
        return version.getUtf8String(0);
    }

    public static void main(String[] args) {
        String pcapVersion = PCap.pcapVersion();
        System.out.println(pcapVersion);
    }
}
