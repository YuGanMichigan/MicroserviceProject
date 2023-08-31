package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public void createProduct(ProductRequest productRequest){
        Product product = modelMapper.map(productRequest, Product.class);
        productRepository.insert(product);
        log.info("Product {} is created with id : {}", product.getName(),product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ProductResponse.class))
                .toList();
    }
}
