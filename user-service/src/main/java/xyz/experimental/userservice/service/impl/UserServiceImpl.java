package xyz.experimental.userservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import xyz.experimental.authutil.PasswordUtil;
import xyz.experimental.commonutil.IDGenerator;
import xyz.experimental.userservice.exception.CustomRuntimeException;
import xyz.experimental.userservice.model.User;
import xyz.experimental.userservice.model.dto.LoginDTO;
import xyz.experimental.userservice.model.dto.SignUpDTO;
import xyz.experimental.userservice.model.dto.UserDTO;
import xyz.experimental.userservice.repository.UserRepository;
import xyz.experimental.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordUtil passwordUtil;

	@Autowired
	private IDGenerator idGenerator;

	@Override
	public UserDTO signUp(SignUpDTO signUpDTO) {

		if (userRepository.existsByEmailId(signUpDTO.getEmailId())) {
			throw new CustomRuntimeException(HttpStatus.CONFLICT, "User with the provided email ID already exists.");
		}

		if (signUpDTO.getPhoneNumber() != null && userRepository.existsByPhoneNumber(signUpDTO.getPhoneNumber())) {
			throw new CustomRuntimeException(HttpStatus.CONFLICT,
					"User with the provided phone number already exists.");
		}

		User user = new User();
		BeanUtils.copyProperties(signUpDTO, user);
		user.setUserId(idGenerator.generateUserId());
		user.setPasswordHash(passwordUtil.encodePassword(signUpDTO.getPassword()));
		userRepository.save(user);

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);

		return userDTO;

	}

	@Override
	public UserDTO login(LoginDTO loginDTO) {

		User user = userRepository.findByEmailId(loginDTO.getEmailId());

		if (user == null) {
			throw new CustomRuntimeException(HttpStatus.UNAUTHORIZED, "No user found for the provided email ID.");
		}

		if (!passwordUtil.isPasswordValid(loginDTO.getPassword(), user.getPasswordHash())) {
			throw new CustomRuntimeException(HttpStatus.UNAUTHORIZED, "Incorrect password.");
		}

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);

		return userDTO;

	}

	@Override
	public UserDTO getUserByUserId(String userId) {

		User user = userRepository.findByUserId(userId);

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);

		return userDTO;

	}

	@Override
	public UserDTO getUserByEmailId(String emailId) {

		User user = userRepository.findByEmailId(emailId);

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);

		return userDTO;

	}

}
