package com.pmj.crm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PmjCrmApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 使用md5密码加密两次
     */
    @Test
    public void encryptPassword() {
        System.out.println("使用md5加密两次：" +new SimpleHash("md5","123456","admin"+"6340248c726afd2ff71e2413ae604ce247ae2fd022fcd6d5",2).toHex());
    }

    /**
     * 生成随机盐
     */
    @Test
    public void randomSalt() {
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(24).toHex();
        System.out.println(hex+"test111");
    }

}
