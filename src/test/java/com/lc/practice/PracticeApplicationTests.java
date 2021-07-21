package com.lc.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        int max = 0;
        System.out.println(max < -1 ? -1 : 0);
    }
}
