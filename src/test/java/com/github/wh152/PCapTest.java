package com.github.wh152;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.MatcherAssert;
import org.npcap.sockaddr;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.hamcrest.Matchers.matchesRegex;

public class PCapTest {

    @Test
    public void shouldReturnCorrectVersionString() {
        String pcapVersion = PCap.pcapVersion();
        MatcherAssert.assertThat(pcapVersion, matchesRegex(
                "Npcap version \\d+\\.\\d+, based on libpcap version \\d+\\.\\d+\\.\\d+"
        ));
    }

    @Test
    public void validateSocketIPAddress() {
        try (Arena arena = Arena.openConfined()) {
            MemorySegment socket = MemorySegment.allocateNative(sockaddr.sizeof(), arena.scope());
            MemorySegment ipAddress = sockaddr.sa_data$slice(socket);

            String quadNine = "9.9.9.9";
            ipAddress.copyFrom(MemorySegment.ofArray(quadNine.getBytes()));

            assertEquals(quadNine, ipAddress.getUtf8String(0));
        }
    }

    @Test
    public void validateSocketIPLocalhostUsingNetLibrary() {
        try (Arena arena = Arena.openConfined()) {
            MemorySegment socket = MemorySegment.allocateNative(sockaddr.sizeof(), arena.scope());
            MemorySegment ipAddress = sockaddr.sa_data$slice(socket);

            String localhost = InetAddress.getByName("localhost").getHostAddress();
            ipAddress.copyFrom(MemorySegment.ofArray(localhost.getBytes()));

            assertEquals("127.0.0.1", ipAddress.getUtf8String(0));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
