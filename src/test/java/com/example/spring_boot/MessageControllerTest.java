package com.example.spring_boot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TruthProviderTest {

    @Test
    void testThatTruthIsTrue() {
        TruthProvider provider = new TruthProvider();

        assertTrue(provider.invoke());
    }
}

class TruthProvider {

    Boolean invoke() {
        return true;
    }
}