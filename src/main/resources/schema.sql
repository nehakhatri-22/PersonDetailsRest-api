DROP TABLE IF EXISTS TBL_PERSON;

CREATE
    TABLE TBL_PERSON (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         first_name VARCHAR(250) NOT NULL,
                         last_name VARCHAR(250) NOT NULL,
                         age INT(3) DEFAULT NULL,
                         favourite_color VARCHAR(30) DEFAULT NULL
);

INSERT INTO TBL_PERSON (id,first_name,last_name,age,favourite_color) VALUES(1,'Neha','Khatri', 29, 'White');
INSERT INTO TBL_PERSON (id,first_name,last_name,age,favourite_color) VALUES(2,'Sneha','Khatri', 9, 'White');
INSERT INTO TBL_PERSON (id,first_name,last_name,age,favourite_color) VALUES(3,'Apoorva','Khatri', 29, 'White');
