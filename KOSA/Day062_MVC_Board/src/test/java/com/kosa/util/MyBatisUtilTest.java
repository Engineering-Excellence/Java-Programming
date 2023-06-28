package com.kosa.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class MyBatisUtilTest {

    @Test
    void testGetSession() {
        log.info("testGetSession()");
        boolean result = MyBatisUtil.getSession() != null;
        Assertions.assertTrue(result, "FAIL");
    }
}