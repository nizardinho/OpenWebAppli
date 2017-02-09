CREATE TABLE user (id INT PRIMARY KEY, username VARCHAR(15) NOT NULL, password VARCHAR(15), user_role  );
CREATE TABLE boat (id INT PRIMARY KEY, boatname VARCHAR(15) NOT NULL, id_client int   );