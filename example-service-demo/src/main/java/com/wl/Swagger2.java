package com.wl;

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
 * Swagger2 初始化类
 *
 * @author wl
 * @description TODO
 * @date 2019/4/30
 */
@Configuration
@EnableSwagger2 // 启用Swagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(
                // 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
            RequestHandlerSelectors.basePackage("com.wl"))
            .paths(PathSelectors.any()).build();
    }

    /**
     *  创建API的基本信息，这些信息会在Swagger UI中进行显示
     * @return
     */
    private ApiInfo apiInfo() {
        // API 标题
        return new ApiInfoBuilder().title("wenlin demo服务API")
            .description("提供wenlin demo服务RESTful APIs")// API描述
            .contact(new Contact("wl", "http://www.wl.cn", "wenlin@163.com"))// 联系人
            .version("1.0-SNAPSHOT")// 版本号
            .build();
    }

}
