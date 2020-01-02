package com.md.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(AdminApplication.class);
        //支持生成 pid 文件
        springApplication.addListeners(new ApplicationPidFileWriter("admin.pid"));
        springApplication.run(AdminApplication.class, args);
    }

}
