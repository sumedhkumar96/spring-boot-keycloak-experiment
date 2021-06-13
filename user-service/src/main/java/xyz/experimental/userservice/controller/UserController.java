package xyz.experimental.userservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xyz.experimental.userservice.model.dto.LoginDTO;
import xyz.experimental.userservice.model.dto.SignUpDTO;
import xyz.experimental.userservice.model.dto.UserDTO;
import xyz.experimental.userservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserDTO signUp(@RequestBody @Valid SignUpDTO signUpDTO) {
		return userService.signUp(signUpDTO);
	}
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public UserDTO login(@RequestBody @Valid LoginDTO loginDTO) {
		return userService.login(loginDTO);
	}

}
