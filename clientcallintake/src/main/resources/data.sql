-- Mock data for clients and call records
-- This file will be automatically executed by Spring Boot to populate the database

-- Insert 5 sample clients
INSERT INTO client (id, first_name, last_name, phone_num, email) VALUES
(1, 'John', 'Doe', '123-456-7890', 'john.doe@example.com'),
(2, 'Jane', 'Smith', '234-567-8901', 'jane.smith@example.com'),
(3, 'Bob', 'Johnson', '345-678-9012', 'bob.johnson@example.com'),
(4, 'Alice', 'Williams', '456-789-0123', 'alice.williams@example.com'),
(5, 'Charlie', 'Brown', '567-890-1234', 'charlie.brown@example.com');

-- Insert 10 sample call records
INSERT INTO call_record (id, call_reason, notes, priority, status, created_at, client_id) VALUES
(1, 'Billing inquiry', 'Customer wants to know about recent charges', 'MODERATE', 'OPEN', '2024-01-15 10:30:00', 1),
(2, 'Technical support', 'Issue with login system', 'HIGH', 'IN_PROGRESS', '2024-01-16 14:20:00', 2),
(3, 'Product information', 'Asking about new features', 'LOW', 'RESOLVED', '2024-01-17 09:15:00', 3),
(4, 'Complaint', 'Service was delayed', 'HIGH', 'CLOSED', '2024-01-18 16:45:00', 1),
(5, 'General inquiry', 'Questions about account settings', 'MODERATE', 'OPEN', '2024-01-19 11:00:00', 4),
(6, 'Billing dispute', 'Disagreement over charges', 'HIGH', 'IN_PROGRESS', '2024-01-20 13:30:00', 2),
(7, 'Feature request', 'Suggestion for new functionality', 'LOW', 'OPEN', '2024-01-21 08:45:00', 5),
(8, 'Password reset', 'Forgot password assistance', 'MODERATE', 'RESOLVED', '2024-01-22 15:20:00', 3),
(9, 'Account closure', 'Customer wants to close account', 'HIGH', 'IN_PROGRESS', '2024-01-23 12:10:00', 4),
(10, 'Feedback', 'Positive feedback on recent update', 'LOW', 'CLOSED', '2024-01-24 17:00:00', 5);