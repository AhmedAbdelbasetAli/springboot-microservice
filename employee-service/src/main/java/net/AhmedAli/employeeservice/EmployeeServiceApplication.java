package net.AhmedAli.employeeservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot Employee-Service REST API Documentation",
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
				description = "Spring Boot Employee-Service Documentation"
				
		)
)
public class EmployeeServiceApplication {

   // @Bean
	//public RestTemplate restTemplate(){
		//return new RestTemplate();
	//}
    @Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
