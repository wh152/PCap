package com.github.wh152.wrapper;

public enum InterfaceFlags {

    PCAP_IF_LOOPBACK("interface is loopback", 1),
    PCAP_IF_UP("interface is up", 2),
    PCAP_IF_RUNNING("interface is running", 4),
    PCAP_IF_WIRELESS("interface is wireless", 8),
    PCAP_IF_CONNECTION_STATUS_UNKNOWN("unknown", 0),
    PCAP_IF_CONNECTION_STATUS_CONNECTED("connected", 16),
    PCAP_IF_CONNECTION_STATUS_DISCONNECTED("disconnected", 32),
    PCAP_IF_CONNECTION_STATUS_NOT_APPLICABLE("not applicable", 48);

    private final String description;

    private final int flag;

    InterfaceFlags(String description, int flag) {
        this.description = description;
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public int getFlag() {
        return flag;
    }
}
