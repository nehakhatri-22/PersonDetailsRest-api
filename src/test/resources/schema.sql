DROP TABLE IF EXISTS TBL_PERSON;

CREATE
    TABLE TBL_PERSON (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         first_name VARCHAR(250) NOT NULL,
                         last_name VARCHAR(250) NOT NULL,
                         age INT(3) DEFAULT NULL,
                         favourite_color VARCHAR(30) DEFAULT NULL
);

INSERT INTO TBL_PERSON (first_name, last_name, age,favourite_color) VALUES
('1','Aliko', '22', 'Billionaire Industrialist'),
('2','Bill', '12', 'Billionaire Tech Entrepreneur'),
('3','Folrunsho', '91', 'Billionaire Oil Magnate');