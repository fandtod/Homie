package com.stella;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.stella.web.*.controller")
public class HomieDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomieDemoApplication.class, args);
	}

}
