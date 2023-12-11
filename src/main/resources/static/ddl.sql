CREATE TABLE grocery_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES grocery_items(id)
);

INSERT INTO grocery_items (name, price, quantity) VALUES
('Rice', 2.5, 100),
('Apples', 1.2, 150),
('Milk', 1.8, 80);
-- Add more grocery items as needed


INSERT INTO users (username, password, role) VALUES
('admin', 'adminpassword', 'admin'),
('user1', 'user1password', 'user'),
('user2', 'user2password', 'user');
-- Add more users as needed


INSERT INTO orders (user_id, order_date, status) VALUES
(2, '2023-12-01T10:00:00', 'pending'),
(3, '2023-12-02T11:30:00', 'shipped');
-- Add more orders as needed


INSERT INTO order_items (order_id, item_id, quantity) VALUES
(1, 1, 5),
(1, 2, 3),
(2, 3, 2);
-- Add more order items as needed

