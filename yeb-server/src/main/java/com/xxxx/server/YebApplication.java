package com.xxxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yebai
 * @version V1.0
 * @Package com.xxxx.server
 * @Description
 * @date 2021/5/29 22:51
 * @ClassName YebApplication
 */
@SpringBootApplication
@MapperScan("com.xxxx.server.mapper")
public class YebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class,args);
    }
}
