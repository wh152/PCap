package com.github.wh152;

import org.junit.jupiter.api.Test;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.matchesRegex;

public class PCapTest {

    @Test
    public void shouldReturnCorrectVersionString() {
        String pcapVersion = PCap.pcapVersion();
        MatcherAssert.assertThat(pcapVersion, matchesRegex(
                "Npcap version \\d+\\.\\d+, based on libpcap version \\d+\\.\\d+\\.\\d+"
        ));
    }
}
