package com.demo.mpb.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.produces(formatosValidos())
				.consumes(formatosValidos());
	}
	
	public Set<String> formatosValidos(){
		return new HashSet<String>(Arrays.asList("application/json","application/xml"));
	}
	
	public ApiInfo apiInfo() {
		
		return new ApiInfo(
				"Servicios MPB API", 
				"Api que permite el registro, modificacion y eliminacion de informacion de la institucion del colegio Maria Parado de Bellido",
				"V.1.0", 
				"Uso para el proyecto Final del curso de Desarrollo de Software Certificador",
				new Contact("Alex Martinez","alex@gmail.com","A18102057"), 
				"Licencia de API",
				"Url de licencia",
				Collections.emptyList());
	}
}
