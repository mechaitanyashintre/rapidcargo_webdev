create database freight_transport_region_vehicles;
use freight_transport_region_vehicles;

-- ftr_vehicles table
DROP TABLE IF EXISTS ftr_vehicles;
CREATE TABLE ftr_vehicles (
    vehicle_number VARCHAR(20) NOT NULL,
    vehicle_name VARCHAR(50) DEFAULT NULL,
    max_lifting_capacity BIGINT DEFAULT NULL,
    retire_date DATE DEFAULT NULL,
    vehicle_status VARCHAR(30) DEFAULT NULL,
    harbor_location VARCHAR(30) DEFAULT NULL,
    country VARCHAR(30) DEFAULT NULL,
    PRIMARY KEY (vehicle_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_vehicles WRITE;
INSERT INTO ftr_vehicles VALUES
('BH2343', 'Aerial crane', 1000, '2022-01-21', 'InProgress', 'Sydney Harbor', 'Australia'),
('BK7890', 'Tower crane', 20, '2030-12-20', 'Active', 'Johor Port', 'Malaysia'),
('CT7867', 'Crawler crane', 550, '2024-05-27', 'InActive', 'Busan Port', 'South Korea'),
('DG8986', 'Double treadwheel crane', 3, '2025-03-22', 'InProgress', 'Jurong', 'Singapore'),
('ER5849', 'Deck crane', 40, '2032-09-28', 'Active', 'Halifax', 'Canada');
UNLOCK TABLES;