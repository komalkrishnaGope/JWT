package com.harvis.paymatix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class PaymatixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymatixApplication.class, args);
	}

}
