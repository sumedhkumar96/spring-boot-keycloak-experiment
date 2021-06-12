package xyz.experimental.productservice.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductDTO {
	
	private Long id;
	
	private LocalDateTime createdOn;
	
	private LocalDateTime updatedOn;
	
	private String productId;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;

}
