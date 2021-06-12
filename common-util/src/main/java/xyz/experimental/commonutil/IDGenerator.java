package xyz.experimental.commonutil;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class IDGenerator {
	
	public String generateProductId() {
		UUID uuid = UUID.randomUUID();
		return "XYZ-EXP-PROD-" + uuid;
	}
	
	public String generateUserId() {
		UUID uuid = UUID.randomUUID();
		return "XYZ-EXP-USR-" + uuid;
	}

}
