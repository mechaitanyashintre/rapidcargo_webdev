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
('92012', 'SD3456', NULL, 'InProgress'),
('32014', 'ME890', '012', 'Completed'),
('32015', '007890', '0114', 'InProgress'),
('92016', '842343', '0115', 'Completed');
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
('01', 'T11'),
('03', '01'),
('03', '014'),
('02', '015'),
('02016', '115'),
('12017', '1111');
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


-- ftr_login table
DROP TABLE IF EXISTS ftr_login;
CREATE TABLE ftr_login (
    user_id BIGINT NOT NULL,
    password VARCHAR(30) DEFAULT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_login WRITE;
INSERT INTO ftr_login VALUES
(10001, 'anniethomas!12'),
(10002, 'mikehillyer@12'),
(10003, 'jonstephens!12'),
(10004, 'andrewfuller@12'),
(10005, 'nancydavolio#123'),
(10010, 'anniethomas!12'),
(10017, 'anniethomas!12');
UNLOCK TABLES;


-- ftr_user table
DROP TABLE IF EXISTS ftr_user;
CREATE TABLE ftr_user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) DEFAULT NULL,
    last_name VARCHAR(30) DEFAULT NULL,
    email_id VARCHAR(30) DEFAULT NULL,
    mobile_number BIGINT DEFAULT NULL,
    password VARCHAR(30) DEFAULT NULL,
    nationality VARCHAR(30) DEFAULT NULL,
    passport_number VARCHAR(30) DEFAULT NULL,
    permanent_address VARCHAR(200) DEFAULT NULL,
    office_address VARCHAR(200) DEFAULT NULL,
    personal_identification_number BIGINT DEFAULT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=10020 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES ftr_user WRITE;
INSERT INTO ftr_user VALUES
(10001, 'Annie', 'Thomas', 'anniethomas@gmail.com', 8790890990, 'anniethomas!12', 'Indian', 'A7878765', '295/12, Cross, Lalbagh Road, K S Garden, Bangalore', '16, Gandhibazaarmnrd, basavangudi, Basavanagudi, Bangalore', 676767898765),
(10002, 'Mike', 'Hillyer', 'mikehillyer@yahoo.com', 8790890990, 'mikehillyer@12', 'Indian', 'H3489098', '295/12, Cross, Lalbagh Road, K S Garden, Bangalore', '16, Gandhibazaarmnrd, basavangudi, Basavanagudi, Bangalore', 345678902345);
UNLOCK TABLES;


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