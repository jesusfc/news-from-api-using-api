package com.jesusfc.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

}
