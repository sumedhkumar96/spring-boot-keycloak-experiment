package xyz.experimental.productservice.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ProductUtil {
	
	public String generateProductId() {
		UUID uuid = UUID.randomUUID();
		return "XYZ-EXP-PROD-" + uuid;
	}

}
