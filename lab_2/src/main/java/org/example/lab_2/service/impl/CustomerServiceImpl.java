package org.example.lab_2.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab_2.domain.entity.Category;
import org.example.lab_2.domain.entity.Product;
import org.example.lab_2.repository.CategoryRepository;
import org.example.lab_2.repository.ProductRepository;
import org.example.lab_2.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

//    @Override
//    List<Product> getProducts() {
//
//    }

}
