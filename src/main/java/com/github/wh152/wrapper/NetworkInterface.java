package com.github.wh152.wrapper;

import org.npcap.pcap_if;

import java.lang.foreign.MemorySegment;

public class NetworkInterface {

    private NetworkInterface next;
    private String name;
    private String description;
    private NetworkAddress addresses;
    private int interfaceFlag;

    public NetworkInterface(MemorySegment pcapIf) {
        System.out.println("In NetworkAddress constructor");
        System.out.println(pcapIf.byteSize());
        if (pcapIf != null) {
            System.out.println("pcapIf not null");
//            if (pcap_if.next$get(pcapIf) != null) {
//                System.out.println("pcapIf not null");
//                this.next = new NetworkInterface(pcap_if.next$get(pcapIf));
//            }
            this.name = pcap_if.name$get(pcapIf).getUtf8String(0);
            this.description = pcap_if.description$get(pcapIf).getUtf8String(0);
            if (pcap_if.addresses$get(pcapIf) != null) {
                System.out.println("addresses not null");
                this.addresses = new NetworkAddress(pcap_if.addresses$get(pcapIf));
            }
            this.interfaceFlag = pcap_if.flags$get(pcapIf);
        }
    }

    public NetworkInterface getNext() {
        return next;
    }

    public void setNext(NetworkInterface next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NetworkAddress getAddresses() {
        return addresses;
    }

    public void setAddresses(NetworkAddress addresses) {
        this.addresses = addresses;
    }

    public int getInterfaceFlag() {
        return interfaceFlag;
    }

    public void setInterfaceFlag(int interfaceFlag) {
        this.interfaceFlag = interfaceFlag;
    }
}
