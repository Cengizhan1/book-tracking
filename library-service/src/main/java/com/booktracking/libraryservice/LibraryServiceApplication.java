package com.booktracking.libraryservice;

import com.booktracking.libraryservice.client.RetreiveMessageErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}


	//Feign Client Error Handling
	@Bean
	public ErrorDecoder errorDecoder() {
		return new RetreiveMessageErrorDecoder();
	}
}
