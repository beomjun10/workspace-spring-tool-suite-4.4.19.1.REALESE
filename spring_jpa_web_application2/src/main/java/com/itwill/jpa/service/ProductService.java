package com.itwill.jpa.service;


import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.dto.ProductUpdateDto;
@Transactional( propagation = Propagation.REQUIRED,
				isolation = Isolation.READ_COMMITTED,
				rollbackFor = RuntimeException.class)
public interface ProductService {
	
    ProductResponseDto getProduct(Long no);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto updateProduct(ProductUpdateDto product) throws Exception;

    void deleteProduct(Long no) throws Exception;

	List<ProductResponseDto> products();

}