package com.jc_gomis.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
    //https://github.com/eazybytes/microservices/blob/3.4.1/section2/accounts/src/main/java/com/eazybytes/accounts/mapper/AccountsMapper.java
}
