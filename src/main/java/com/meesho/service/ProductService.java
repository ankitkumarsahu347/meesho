package com.meesho.service;

import com.meesho.dao.ProductDAO;
import com.meesho.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts() { return productDAO.findAll(); }
    public Product getProduct(int id) { return productDAO.findById(id); }
}
