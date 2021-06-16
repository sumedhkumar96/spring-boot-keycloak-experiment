package xyz.experimental.productservice.model.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String productId;
	
	@NotBlank
	private String name;
	
	private String description;
	
	@NotNull
	private BigDecimal price;

}
