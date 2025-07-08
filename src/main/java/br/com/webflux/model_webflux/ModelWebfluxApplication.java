package br.com.webflux.model_webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("be.com.webflux")
public class ModelWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelWebfluxApplication.class, args);
	}

}
