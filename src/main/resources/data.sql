--product are only from place holder project, should be deleted later
-- First, clean up existing data (if any) in reverse order of dependencies
DELETE FROM product;

-- Sample data for Product entity
INSERT INTO product (name, description, price, quantity) VALUES
                                                             ('Laptop', 'High-performance laptop with 16GB RAM', 1299.99, 10),
                                                             ('Smartphone', 'Latest model with 128GB storage', 799.99, 20),
                                                             ('Headphones', 'Wireless noise-cancelling headphones', 199.99, 30),
                                                             ('Tablet', '10-inch screen with 64GB storage', 349.99, 15),
                                                             ('Smartwatch', 'Fitness tracking and notifications', 249.99, 25);


-- First, clean up existing data (if any) in reverse order of dependencies
DELETE FROM "email";
DELETE FROM "users";

-- Sample data for User entity
INSERT INTO "users" (username, email, password) VALUES
                                                   ('john_doe', 'john.doe@example.com', 'password123'),
                                                   ('jane_smith', 'jane.smith@example.com', 'mypassword456'),
                                                   ('alice_williams', 'alice.williams@example.com', 'securepass789'),
                                                   ('bob_brown', 'bob.brown@example.com', 'bobpassword321'),
                                                   ('charlie_jones', 'charlie.jones@example.com', 'charliepass654');

INSERT INTO "email" (from_email, to_email, subject, body, timestamp) VALUES
                                                                         ('alice.williams@example.com', 'bob.brown@example.com', 'Project Update', 'The project is progressing well, please review the latest updates.', '2025-04-13 11:00:00'),
                                                                         ('john.doe@example.com', 'alice.williams@example.com', 'Lunch Plans', 'Are you available for lunch at 1 PM today?', '2025-04-13 13:00:00'),
                                                                         ('jane.smith@example.com', 'bob.brown@example.com', 'Project Deadline', 'The deadline for the project is fast approaching, please make sure all tasks are completed.', '2025-04-13 14:00:00'),
                                                                         ('bob.brown@example.com', 'john.doe@example.com', 'Feedback on Report', 'Here is the feedback on your report. Please check the attached comments.', '2025-04-13 10:00:00'),
                                                                         ('charlie.jones@example.com', 'alice.williams@example.com', 'Follow-up on Task', 'Just wanted to follow up on the task we discussed last week. Any updates?', '2025-02-01 10:00:00');


