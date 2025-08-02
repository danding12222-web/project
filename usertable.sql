CREATE TABLE user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100),
  userphonenumber VARCHAR(20) UNIQUE,
  email VARCHAR(100),
  password VARCHAR(100)
);
