package xyz.experimental.userservice.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDTO {
	
	@NotBlank
	private String name;
	
	private String phoneNumber;
	
	@NotBlank
	private String emailId;
	
	private String userId;

}
