package com.pmj.crm.utils;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecurityUtilsTest {

    @Test
    public void encryptPassword() {
        System.out.println(SecurityUtils.encryptPassword("123456","adminff0bedfaa6285c2bf193f9a33df6e6df0c54e8179d478da6"));
    }

    @Test
    public void randomSalt() {
        System.out.println(SecurityUtils.randomSalt());
    }
}