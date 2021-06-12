package xyz.experimental.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.experimental.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findByProductId(String productId);

}
