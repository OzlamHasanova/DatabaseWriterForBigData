package com.DatabaseWriterForBigData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DatabaseWriterForBigDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseWriterForBigDataApplication.class, args);
	}

}
