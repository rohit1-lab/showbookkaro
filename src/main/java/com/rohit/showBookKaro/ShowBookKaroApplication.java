package com.rohit.showBookKaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class ShowBookKaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowBookKaroApplication.class, args);
	}

}
