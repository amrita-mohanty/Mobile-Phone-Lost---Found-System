CREATE TABLE products (
  id INTEGER NOT NULL PRIMARY KEY,
  description varchar(255),
  price decimal(15,2)
);
CREATE INDEX products_description ON products(description);

CREATE TABLE users (
  username varchar(255) NOT NULL PRIMARY KEY,
  password varchar(255),
  mobileNumber varchar(255),
  emailAddress varchar(255)
);
CREATE INDEX username_index ON users(username);

CREATE TABLE messages (
  username varchar(255),
  message varchar(255),
  date_received TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);
CREATE INDEX message_index ON messages(username);
