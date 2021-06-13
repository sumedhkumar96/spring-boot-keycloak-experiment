package xyz.experimental.productservice.model.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String productId;
	
	@NotBlank
	private String name;
	
	private String description;
	
	@NotBlank
	private BigDecimal price;

}
