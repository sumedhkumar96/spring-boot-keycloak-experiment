package xyz.experimental.productservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "xyzexp_product", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Product {

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
	@Column(name = "product_id")
	private String productId;

	@NotBlank
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "price")
	private BigDecimal price;

}
