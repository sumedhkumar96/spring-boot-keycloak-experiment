package xyz.experimental.authutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AuthUtilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthUtilApplication.class, args);
	}

}
