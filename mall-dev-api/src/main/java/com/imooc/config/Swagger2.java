package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2020-08-07
 */
//让该类能够被容器扫描到
@Configuration
//开启
@EnableSwagger2
public class Swagger2 {

    //    http::/localhost:8088/swagger-ui.html
    //    http::/localhost:8088/doc.html

    // 配置swagger2的核心配置 docket
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)     // 指定api类型为swagger2
                .apiInfo(apiInfo())                        // 用于定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.imooc.controller"))  // 指定controller包
                .paths(PathSelectors.any())                   // 所有controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口api")                   // 文档页标题
                .contact(new Contact("Lyy",
                        "lyy-0217.blog.csdn.net",
                        "liuyangyang03@kuaishou.com"))     // 联系人信息
                .description("专为天天吃货提供的api文档")
                .version("1.0.0")                               // 文档的版本号
                .termsOfServiceUrl("lyy-0217.blog.csdn.net")    // 网站地址
                .build();
    }
}
