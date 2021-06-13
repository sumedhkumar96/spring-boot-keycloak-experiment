package xyz.experimental.userservice.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SignUpDTO extends LoginDTO {
	
	@NotBlank
	private String name;
	
	private String phoneNumber;

}
