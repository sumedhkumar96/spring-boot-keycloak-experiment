package xyz.experimental.productservice.service;

import xyz.experimental.productservice.model.dto.ProductDTO;

public interface ProductService {
	
	public ProductDTO createProduct(ProductDTO productDTO);
	
	public ProductDTO getProductByProductId(String productId);

}
