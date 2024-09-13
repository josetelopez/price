package com.bcnc.inditex.test.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.bcnc.inditex.test.price","com.bcnc.inditex.test.price.infrastructure.adapter.repository.JpaDataH2PriceRepository"})
public class PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
	}

}
