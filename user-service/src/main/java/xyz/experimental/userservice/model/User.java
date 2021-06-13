package xyz.experimental.userservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "xyzexp_user", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@CreatedDate
	@Column(name = "created_on", updatable = false)
	private LocalDateTime createdOn;

	@LastModifiedDate
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotBlank
	@Column(name = "email_id")
	private String emailId;
	
	@NotBlank
	@Column(name = "password_hash")
	private String passwordHash;
	
	@NotBlank
	@Column(name = "user_id")
	private String userId;

}
