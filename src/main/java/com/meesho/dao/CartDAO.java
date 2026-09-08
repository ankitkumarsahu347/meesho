package com.meesho.dao;

import com.meesho.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAO {
    private final JdbcTemplate jdbcTemplate;

    public CartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(int userId, int productId, int quantity) {
        jdbcTemplate.update("INSERT INTO cart_items(user_id,product_id,quantity) VALUES(?,?,?) " +
                "ON DUPLICATE KEY UPDATE quantity=quantity+VALUES(quantity)", userId, productId, quantity);
    }

    public List<Product> getProducts(int userId) {
        return jdbcTemplate.query("SELECT p.id,p.name,p.description,p.price,p.stock,p.category,p.image_url " +
                "FROM cart_items c JOIN products p ON c.product_id=p.id WHERE c.user_id=? ORDER BY c.id DESC",
                (rs, rowNum) -> {
                    Product p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setPrice(rs.getDouble("price"));
                    p.setStock(rs.getInt("stock"));
                    p.setCategory(rs.getString("category"));
                    p.setImageUrl(rs.getString("image_url"));
                    return p;
                }, userId);
    }
}
