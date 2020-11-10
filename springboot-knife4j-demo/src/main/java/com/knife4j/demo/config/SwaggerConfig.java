package com.knife4j.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description 侵入式接口文档配置
 * @notice 文档访问地址为： http://${host}:${port}/doc.html
 * @Author lcz
 * @Date 2020/02/25 09:27
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
/*针对dev test模式开启*/
//@Profile({"dev","test"})
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket createRestApiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfoV1())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.knife4j.demo.api.v1"))
                .paths(PathSelectors.any())
                .build()
                .groupName("项目-V1版本");
    }

    private ApiInfo apiInfoV1() {
        return new ApiInfoBuilder()
                .title("项目-V1版本")
                .description("项目起始版本")
                .termsOfServiceUrl("http://localhost:8080/plum/")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfoV2())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.knife4j.demo.api.v2"))
                .paths(PathSelectors.any())
                .build()
                .groupName("项目-V2版本");
    }

    private ApiInfo apiInfoV2() {
        return new ApiInfoBuilder()
                .title("项目-V2版本")
                .description("项目起始版本")
                .termsOfServiceUrl("http://localhost:8080/plum/")
                .version("2.0")
                .build();
    }
}
