package com.github.wh152.wrapper;

import org.npcap.sockaddr;

import java.lang.foreign.MemorySegment;

public class SocketAddress {


    private short family;
    private String ipAddress;

    public SocketAddress(MemorySegment sockAddr) {
        System.out.println("In SocketAddress constructor");
        if (sockAddr != null) {
            System.out.println("sockAddr not null");
            this.family = sockaddr.sa_family$get(sockAddr);
            this.ipAddress = sockaddr.sa_data$slice(sockAddr).getUtf8String(0);
        }
    }

    public short getFamily() {
        return this.family;
    }

    public void setFamily(short family) {
        this.family = family;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        if (ipAddress.length() > 14) {
            throw new IllegalArgumentException("IP address must be no more than 14 characters");
        }

        this.ipAddress = ipAddress;
    }
}
