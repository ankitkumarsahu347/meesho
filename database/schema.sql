CREATE DATABASE IF NOT EXISTS meesho;
USE meesho;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(500),
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    category VARCHAR(100),
    image_url VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS cart_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    UNIQUE KEY uq_cart_user_product (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

INSERT INTO products(name,description,price,stock,category,image_url) VALUES
('Women Kurti','Printed cotton kurti for daily wear',499,50,'Women Fashion','https://images.unsplash.com/photo-1583391733956-6c78276477e2?w=600'),
('Casual Saree','Elegant saree for festive and casual occasions',799,40,'Women Fashion','https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=600'),
('Handbag','Stylish everyday handbag',599,30,'Bags','https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=600'),
('Sneakers','Comfortable casual sneakers',999,25,'Footwear','https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600');
