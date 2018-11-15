package com.spoon;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RunAppUserConsumer2 {

	public static void main(String[] args) {
		SpringApplication.run(RunAppUserConsumer2.class, args);
	}

}
