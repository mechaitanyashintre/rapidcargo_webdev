create database freight_transport_region_user;
use freight_transport_region_user;

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
