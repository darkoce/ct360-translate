package com.zepp.translate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TranslateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslateServiceApplication.class, args);
	}

}
