package xyz.experimental.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.experimental.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserId(String userId);
	
	public User findByEmailId(String emailId);
	
	public User findByPhoneNumber(String phoneNumber);
	
	public Boolean existsByEmailId(String emailId);
	
	public Boolean existsByPhoneNumber(String phoneNumber);
	
}
