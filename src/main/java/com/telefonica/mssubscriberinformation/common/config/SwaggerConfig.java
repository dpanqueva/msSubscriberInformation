package com.telefonica.mssubscriberinformation.common.config;

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

import java.util.Collections;

/**
 * Class for initial configuration swagger for documentation about microservices
 *
 * @author dpanquev
 * @version 2021-09-14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configuration for show configurations about definitions ms
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Collections.singleton("application/json"))
                .consumes(Collections.singleton("application/json"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.telefonica.mssubscriberinformation"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    /**
     * Configuration for show configurations about definitions ms from properties swagger
     *
     * @return
     */
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Endpoint SubscriberInformation").description("Microservicio para consultar ")
                .contact(new Contact("Organización Telefónica", "https://www.telefonica.co/", "william.londono@telefonica.com")).license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("0.1.0").build();
    }
}
