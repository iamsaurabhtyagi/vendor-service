package com.bmt.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.common"                      // <- if used
})
public class VendorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorServiceApplication.class, args);
	}

}
