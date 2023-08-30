package com.github.wh152;

import java.lang.foreign.*;

import static org.npcap.pcap_h.*;

import org.npcap.pcap_if;

class PCap {

    static {
        System.loadLibrary("wpcap");
    }

    static String pcapVersion() {
        MemorySegment version = pcap_lib_version();
        return version.getUtf8String(0);
    }

    static void listDevices() {
        try (Arena offHeap = Arena.openConfined()) {
            MemorySegment alldevsPP = MemorySegment.allocateNative(C_POINTER, offHeap.scope());
            MemorySegment errbuf = MemorySegment.allocateNative(Constants.ERRBUF_SIZE, offHeap.scope());

            if (pcap_findalldevs(alldevsPP, errbuf) == 0) {
                MemorySegment alldevsp = MemorySegment.ofAddress(alldevsPP.get(C_POINTER, 0).address(),
                        C_POINTER.byteSize(), offHeap.scope());
                MemorySegment pcapIf = MemorySegment.ofAddress(alldevsp.get(C_POINTER, 0).address(),
                        pcap_if.$LAYOUT().byteSize(), offHeap.scope());
                do {
                    String name = pcap_if.name$get(pcapIf).getUtf8String(0);
                    String description = pcap_if.description$get(pcapIf).getUtf8String(0);
                    System.out.println(description + " - " + name);
                    pcapIf = pcap_if.next$get(pcapIf);
                } while (pcapIf.address() != 0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(PCap.pcapVersion() + '\n');
        PCap.listDevices();
    }
}
