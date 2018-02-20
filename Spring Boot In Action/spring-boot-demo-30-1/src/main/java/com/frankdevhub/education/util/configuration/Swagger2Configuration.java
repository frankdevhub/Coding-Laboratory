package com.frankdevhub.education.util.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket accessToken() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api").select()
				.apis(RequestHandlerSelectors.basePackage("com.frankdevhub.education.controller")) // 拦截的包路径
				.paths(regex("/api/.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("io.github.frankdevhub").description("spring boot demo")
				.termsOfServiceUrl("http://www.roncoo.com")
				.contact(new Contact("frankdevhub", "http://www.github.com/frankdevhub", "frankdevhub@163.com"))// 联系
				// .license("Apache License Version 2.0")//
				// .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")//
				.version("1.0")//
				.build();
	}
}
