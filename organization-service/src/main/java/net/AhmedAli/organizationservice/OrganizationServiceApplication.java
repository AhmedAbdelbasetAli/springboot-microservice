package net.AhmedAli.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot Organization-Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ahmed Ali",
						email = "ahmed.kamel1798@yahoo.com"
						
				),
				license = @License(
						name = "Apache 2.0"
						
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Organization-Service Documentation"
				
		)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
