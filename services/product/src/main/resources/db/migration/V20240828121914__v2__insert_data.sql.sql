-- Insert test data into the category table
INSERT INTO category (name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Books', 'Printed and electronic books'),
('Clothing', 'Mens and womens apparel'),
('Home & Kitchen', 'Appliances and kitchenware'),
('Toys', 'Toys for all ages'),
('Sports', 'Sports equipment and accessories'),
('Beauty', 'Cosmetics and personal care products'),
('Automotive', 'Car parts and accessories'),
('Health', 'Healthcare products'),
('Garden', 'Garden tools and supplies');

-- Insert test data into the product table
INSERT INTO product (name, description, available_quantity, price, category_id) VALUES
('Smartphone', 'Latest model smartphone', 50, 699.99, 1),
('Laptop', 'High-performance laptop', 30, 1299.49, 1),
('Fiction Book', 'Bestselling fiction novel', 120, 19.99, 2),
('Non-Fiction Book', 'Informative non-fiction book', 85, 24.99, 2),
('T-Shirt', 'Comfortable cotton t-shirt', 200, 14.95, 3),
('Blender', 'Powerful kitchen blender', 40, 89.99, 4),
('Action Figure', 'Popular superhero action figure', 150, 12.49, 5),
('Basketball', 'Professional basketball', 60, 29.99, 6),
('Lipstick', 'Long-lasting lipstick', 110, 9.99, 7),
('Car Tire', 'Durable car tire', 20, 99.99, 8);
