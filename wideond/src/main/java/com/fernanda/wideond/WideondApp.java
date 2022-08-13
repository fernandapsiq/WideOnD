package com.fernanda.wideond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WideondApp {

	public static void main(String[] args) {
		SpringApplication.run(WideondApp.class, args);
	}

}
