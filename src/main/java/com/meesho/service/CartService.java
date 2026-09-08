package com.meesho.service;

import com.meesho.dao.CartDAO;
import com.meesho.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) { this.cartDAO = cartDAO; }

    public void addToCart(int userId, int productId, int quantity) { cartDAO.add(userId, productId, quantity); }
    public List<Product> getCart(int userId) { return cartDAO.getProducts(userId); }
}
