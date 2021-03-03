package com.bj.no9012;

import com.bj.no9012.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test() {
        Main main = new Main();
        assertEquals("NO", main.pass("(())())"));
        assertEquals("NO", main.pass("(((()())()"));
        assertEquals("YES", main.pass("(()())((()))"));
        assertEquals("NO", main.pass("((()()(()))(((())))()"));
        assertEquals("YES", main.pass("()()()()(()()())()"));
        assertEquals("NO", main.pass("(()((())()("));
        assertEquals("NO", main.pass("(("));
        assertEquals("NO", main.pass("))"));
        assertEquals("NO", main.pass("())(()"));
    }
}