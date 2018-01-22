package ru.ilka.systemintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(value = "ru.ilka.systemintegration")
@PropertySource("classpath:application.properties")
public class Config {

    //http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
    //https://editor.swagger.io//?_ga=2.161732990.35370229.1515158885-1944002411.1515158885#/
    //http://localhost:8088/v2/api-docs
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.ilka.systemintegration.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Info about Systems' integrations REST API",
                "Systems' integrations graph is represented as  an Adjacency matrix with info blocks , developed with Spring (Boot, MVC) , Angular 5",
                "API TOS",
                "Terms of service",
                new Contact("Ilya Kisel", "https://github.com/llka/", "ilya_kisel@epam.com"),
                "License of API", "https://git.epam.com/Ilya_Kisel/javalab/tree/systemIntegrations", Collections.emptyList());
    }
}
