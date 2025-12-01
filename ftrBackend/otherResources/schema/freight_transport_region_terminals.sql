create database freight_transport_region_terminals;
use freight_transport_region_terminals;

-- ftr_terminals table
DROP TABLE IF EXISTS ftr_terminals;
CREATE TABLE ftr_terminals (
    terminal_id VARCHAR(20) NOT NULL,
    terminal_name VARCHAR(100) DEFAULT NULL,
    country VARCHAR(30) DEFAULT NULL,
    item_type VARCHAR(100) DEFAULT NULL,
    terminal_description VARCHAR(200) DEFAULT NULL,
    capacity BIGINT DEFAULT NULL,
    available_capacity BIGINT DEFAULT NULL,
    status VARCHAR(200) DEFAULT NULL,
    harbor_location VARCHAR(30) DEFAULT NULL,
    PRIMARY KEY (terminal_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_terminals WRITE;
INSERT INTO ftr_terminals VALUES
('T11', 'Kakinada', 'India', 'Computer Hardware', 'T11-Computer Hardware', 30000, 19900, 'Available', 'Chennai Port'),
('T12', 'Hazira', 'India', 'Oil Container', 'T12-Oil Container', 9000, 10000, 'NotAvailable', 'Paradip Port'),
('T13', 'Klang', 'Singapore', 'Wood', 'T13-Wood', 85080, 78000, 'Available', 'Jurong'),
('T14', 'Saint John', 'Canada', 'Motorcycles', 'T14-Motorcycles', 85000, 73000, 'Available', 'Port Hawkesbury'),
('T15', 'Brisbane', 'Australia', 'Electronics', 'T15-Electronics', 50000, 12000, 'NotAvailable', 'Sydney Harbor'),
('T16', 'Haldia', 'India', 'Computer Hardware', 'T16-Computer Hardware', 37500, 19000, 'NotAvailable', 'Visakhapatnam Port'),
('T17', 'Tanjung', 'Singapore', 'Oil Container', 'T17-Oil Container', 89080, 50000, 'Available', 'Tanjong Pagar'),
('T18', 'Busan', 'South Korea', 'Wood', 'T18-Wood', 24900, 9900, 'NotAvailable', 'Busan Port');
UNLOCK TABLES;