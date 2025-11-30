create database freight_transport_region_workitems;
use freight_transport_region_workitems;

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


-- ftr_vehicle_workitem table
DROP TABLE IF EXISTS ftr_vehicle_workitem;
CREATE TABLE ftr_vehicle_workitem (
    workitem_id VARCHAR(20) NOT NULL,
    vehicle_number VARCHAR(20) DEFAULT NULL,
    driver_id VARCHAR(20) DEFAULT NULL,
    assigned_workitem_status VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (workitem_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_vehicle_workitem WRITE;
INSERT INTO ftr_vehicle_workitem VALUES
('J2012', 'SD3456', NULL, 'InProgress'),
('J2013', 'ME890', '012', 'Completed'),
('J2014', '007890', '0114', 'InProgress'),
('J2015', '842343', '0115', 'Completed');
UNLOCK TABLES;


-- ftr_workitem_terminal table
DROP TABLE IF EXISTS ftr_workitem_terminal;
CREATE TABLE ftr_workitem_terminal (
    workitem_id VARCHAR(10) NOT NULL,
    terminal_id VARCHAR(10) DEFAULT NULL,
    PRIMARY KEY (workitem_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_workitem_terminal WRITE;
INSERT INTO ftr_workitem_terminal VALUES
('J2012', 'T11'),
('J2013', 'T1'),
('J2014', 'T14'),
('J2015', 'T15'),
('J2016', 'T16'),
('J2017', 'T11');
UNLOCK TABLES;


-- ftr_workitems table
DROP TABLE IF EXISTS ftr_workitems;
CREATE TABLE ftr_workitems (
    workitem_id VARCHAR(20) NOT NULL,
    user_id BIGINT DEFAULT NULL,
    item_name VARCHAR(200) DEFAULT NULL,
    item_type VARCHAR(200) DEFAULT NULL,
    item_description VARCHAR(200) DEFAULT NULL,
    message_to_recipient VARCHAR(200) DEFAULT NULL,
    quantity VARCHAR(100) DEFAULT NULL,
    source_country VARCHAR(30) DEFAULT NULL,
    destination_country VARCHAR(30) DEFAULT NULL,
    origin_harbor_location VARCHAR(30) DEFAULT NULL,
    selected_harbor_location VARCHAR(200) DEFAULT NULL,
    shipping_date DATE DEFAULT NULL,
    amount BIGINT DEFAULT NULL,
    PRIMARY KEY (workitem_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_workitems WRITE;
INSERT INTO ftr_workitems VALUES
('J2012', 10001, 'UPS', 'Computer Hardware', 'Luminous Inverter battery', 'Please confirm once received.', '7500', 'India', 'Singapore', NULL, 'Tanjong Pagar', '2020-08-12', 119992500),
('J2013', 10002, 'Aviation Turbine Fuel', 'Oil Container', 'Fuel for Jet', 'Please confirm once received.', '9200', 'Singapore', 'Malaysia', NULL, 'Johor Port', '2021-11-13', 207368),
('J2014', 10003, 'Round pole milling machine', 'Wood', 'EMTEX 20mm Drilling and Milling Machine DM20', 'Please confirm once received.', '1500', 'India', 'Australia', NULL, 'Tanjong Pagar', '2020-08-22', 195000000),
('J2015', 10004, 'Honda Dio', 'Motorcycles', 'Honda', 'Please confirm once received.', '1331', 'India', 'Canada', NULL, 'Port Hawkesbury', '2020-11-04', 84300216),
('J2016', 10005, 'Washing Machine', 'Electronics', 'Whirlpool 6.5 Kg Fully-Automatic Top Load', 'Please confirm once received.', '3000', 'India', 'Singapore', NULL, 'Jurong', '2020-11-09', 40470000),
('J2017', 10001, 'UPS', 'Computer Hardware', 'Luminous Inverter battery Combo 1100+150AH', 'Please confirm once received.', '100', 'India', 'Singapore', NULL, 'Jurong', '2020-08-12', 1599900),
('J2018', 10002, 'UPS', 'Computer Hardware', 'Luminous Inverter battery Combo 1100+150AH', 'Please confirm once received.', '7500', 'India', 'Singapore', NULL, 'Jurong', '2020-08-12', 119992500);
UNLOCK TABLES;