package xyz.experimental.userservice.service;

import xyz.experimental.userservice.model.dto.LoginDTO;
import xyz.experimental.userservice.model.dto.SignUpDTO;
import xyz.experimental.userservice.model.dto.UserDTO;

public interface UserService {
	
	public UserDTO signUp(SignUpDTO signUpDTO);
	
	public UserDTO login(LoginDTO loginDTO);
	
	public UserDTO getUserByUserId(String userId);
	
	public UserDTO getUserByEmailId(String emailId);

}
