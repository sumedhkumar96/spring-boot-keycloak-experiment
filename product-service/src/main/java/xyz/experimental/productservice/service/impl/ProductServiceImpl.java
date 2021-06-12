package xyz.experimental.productservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.experimental.productservice.model.Product;
import xyz.experimental.productservice.model.dto.ProductDTO;
import xyz.experimental.productservice.repository.ProductRepository;
import xyz.experimental.productservice.service.ProductService;
import xyz.experimental.productservice.util.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductUtil productUtil;

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		productDTO.setProductId(productUtil.generateProductId());
		
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		
		productRepository.save(product);
		
		BeanUtils.copyProperties(product, productDTO);
		
		return productDTO;
		
	}

	@Override
	public ProductDTO getProductByProductId(String productId) {
		
		Product product = productRepository.findByProductId(productId);
		
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(product, productDTO);
		
		return productDTO;
		
	}

}
