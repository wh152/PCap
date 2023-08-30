package com.github.wh152.wrapper;

import org.npcap.pcap_addr;

import java.lang.foreign.MemorySegment;

public class NetworkAddress {

    private NetworkAddress next;
    private SocketAddress socketAddress;
    private SocketAddress netmask;
    private SocketAddress broadcastAddress;
    private SocketAddress destinationAddress;

    public NetworkAddress(MemorySegment pcapAddr) {
        System.out.println("In NetworkAddress constructor");
        System.out.println(pcapAddr.byteSize());
        if (pcapAddr != null) {
            System.out.println("pcapAddr not null");
//            if (pcap_addr.next$get(pcapAddr) != null) {
//                System.out.println("next not null");
//                this.next = new NetworkAddress(pcap_addr.next$get(pcapAddr));
//            }
            if (pcap_addr.addr$get(pcapAddr) != null) {
                System.out.println("addr not null");
                this.socketAddress = new SocketAddress(pcap_addr.addr$get(pcapAddr));
            }
            if (pcap_addr.netmask$get(pcapAddr) != null) {
                System.out.println("netmask not null");
                this.netmask = new SocketAddress(pcap_addr.netmask$get(pcapAddr));
            }
            if (pcap_addr.broadaddr$get(pcapAddr) != null) {
                System.out.println("broadaddr not null");
                this.broadcastAddress = new SocketAddress(pcap_addr.broadaddr$get(pcapAddr));
            }
            if (pcap_addr.dstaddr$get(pcapAddr) != null) {
                System.out.println("dstaddr not null");
                this.destinationAddress = new SocketAddress(pcap_addr.dstaddr$get(pcapAddr));
            }
        }
    }


    public NetworkAddress getNext() {
        return next;
    }

    public void setNext(NetworkAddress next) {
        this.next = next;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public SocketAddress getNetmask() {
        return netmask;
    }

    public void setNetmask(SocketAddress netmask) {
        this.netmask = netmask;
    }

    public SocketAddress getBroadcastAddress() {
        return broadcastAddress;
    }

    public void setBroadcastAddress(SocketAddress broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public SocketAddress getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(SocketAddress destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
