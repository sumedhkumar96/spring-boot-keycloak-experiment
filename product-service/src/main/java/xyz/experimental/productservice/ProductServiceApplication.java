package xyz.experimental.productservice;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = { "xyz.experimental.productservice", "xyz.experimental.commonutil",
		"xyz.experimental.authutil" }, exclude = SecurityAutoConfiguration.class)
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@PostConstruct
	void setDefaultTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
