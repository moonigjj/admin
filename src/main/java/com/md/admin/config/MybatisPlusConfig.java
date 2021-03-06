/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author tangyue
 * @version $Id: MybatisPlusConfig.java, v 0.1 2019-12-10 12:05 tangyue Exp $$
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.md.admin.mapper*");
        return scannerConfigurer;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
