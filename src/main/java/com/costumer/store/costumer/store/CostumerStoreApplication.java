package com.costumer.store.costumer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class CostumerStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostumerStoreApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate(){return new RestTemplate();}

}
