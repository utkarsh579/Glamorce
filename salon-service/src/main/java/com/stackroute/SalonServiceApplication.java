package com.stackroute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableEurekaClient
//@EnableWebMvc
public class SalonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonServiceApplication.class, args);
	}




}
