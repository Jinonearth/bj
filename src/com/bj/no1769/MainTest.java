package com.bj.no1769;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test() {
        Main main = new Main();
        assertEquals("3", main.splitAndSum("3"));
        assertEquals("4", main.splitAndSum("13"));
    }
}