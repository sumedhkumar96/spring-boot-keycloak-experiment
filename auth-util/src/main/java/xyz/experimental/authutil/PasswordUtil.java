package xyz.experimental.authutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public String encodePassword(String password) {
		return bcryptEncoder.encode(password);
	}

	public Boolean isPasswordValid(String enteredPassword, String storedPasswordHash) {
		return bcryptEncoder.matches(enteredPassword, storedPasswordHash);
	}

}
