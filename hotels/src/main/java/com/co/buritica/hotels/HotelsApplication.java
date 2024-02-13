package com.co.buritica.hotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(value = "src/main/java/com/co/buritica/hotels/*")
@EnableJpaRepositories(value= "src/main/java/com/co/buritica/hotels/repositories")
@EntityScan ("src/main/java/com/co/buritica/hotels/models/entities")
@SpringBootApplication
public class HotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);
	}

}
