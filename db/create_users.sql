CREATE TABLE users (
  username varchar(255) NOT NULL PRIMARY KEY,
  password varchar(255),
  mobileNumber varchar(255),
  emailAddress varchar(255),
);
CREATE INDEX username_index ON users(username);
