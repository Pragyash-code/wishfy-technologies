package com.application.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	
	private ApiKey apikey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER , "header");
		
	}
	
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
		
	}
	
	
	private List<SecurityReference> sf(){
		
		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
		
	}
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apikey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}