package xyz.experimental.userservice.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {
	
	@NotBlank
	private String emailId;
	
	@NotBlank
	private String password;

}
