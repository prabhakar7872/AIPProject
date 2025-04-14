
DROP DATABASE IF EXISTS gameDB;
CREATE DATABASE gameDB;

USE gameDB;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    password varchar(50),
    age INT
);

CREATE TABLE user_scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    score INT,
    game_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

select * from users;
SELECT * FROM user_scores;
