create database freight_transport_region_terminals;
use freight_transport_region_terminals;

-- ftr_harbor table
DROP TABLE IF EXISTS ftr_harbor;
CREATE TABLE ftr_harbor (
    country VARCHAR(30) NOT NULL,
    available_harbor_locations VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (country)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_harbor WRITE;
INSERT INTO ftr_harbor VALUES 
('Australia', 'Sydney Harbor'),
('Canada', 'Port Hawkesbury, Halifax'),
('France', 'Old Port Of Marseille, Grand Port Maritime of Dunkirk'),
('Malaysia', 'Johor Port, Puteri, Telaga Harbor, Marina, Penang'),
('Singapore', 'Tanjong Pagar, Jurong');
UNLOCK TABLES;