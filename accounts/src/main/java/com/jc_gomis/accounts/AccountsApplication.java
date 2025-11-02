package com.jc_gomis.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan({("com.jc_gomis.accounts.controllers")})
//@EnableJpaRepositories({"com.jc_gomis.accounts.repositories"})
//@EntityScan({"com.jc_gomis.accounts.entities"})
@SpringBootApplication
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info= @Info(
                title = "Accounts Microservices REST API documentation",
                description = "JC GOMIS Development Laboratory for REST API",
                version = "v1",
                contact = @Contact(
                        name = "JC GOMIS",
                        email = "jeangomistech2018@gmail.com",
                        url= "https://www.linkedin.com/in/-gomis/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.linkedin.com/in/-gomis/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = " JCGomis accounts microservice documentation",
                url = "https://jean-christophe-gomis.com"
        )
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
    //https://github.com/eazybytes/microservices/blob/3.4.1/section2/accounts/src/main/java/com/eazybytes/accounts/mapper/AccountsMapper.java
}
