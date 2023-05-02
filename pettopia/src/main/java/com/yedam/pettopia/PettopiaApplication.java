package com.yedam.pettopia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.pettopia.**.mapper")
public class PettopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PettopiaApplication.class, args);
	}

}
