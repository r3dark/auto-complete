package com.example.autoComplete;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author rohitsharma
 */

@SpringBootApplication
@EnableJpaRepositories ("com.example.autoComplete")
@ComponentScan (basePackages = "com.example.autoComplete")
@EntityScan ("com.example.autoComplete")
@EnableAutoConfiguration
public class AutoCompleteApplication {

	private static final Logger log = LogManager.getLogger(AutoCompleteApplication.class);

	public static void main(String[] args) {

		log.info("Starting auto-complete country application...");

		SpringApplication.run(AutoCompleteApplication.class, args);
	}

}
