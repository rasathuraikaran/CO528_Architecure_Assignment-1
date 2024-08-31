CREATE TABLE BOOK (
                      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                      TITLE VARCHAR(255),
                      AUTHOR VARCHAR(255),
                      ISBN VARCHAR(255)
);
INSERT INTO BOOK (TITLE, AUTHOR, ISBN) VALUES ('Spring Boot in Action', 'Craig Walls', '1234567890');
INSERT INTO BOOK (TITLE, AUTHOR, ISBN) VALUES ('Java Concurrency in Practice', 'Brian Goetz', '1234567891');
INSERT INTO BOOK (TITLE, AUTHOR, ISBN) VALUES ('Effective Java', 'Joshua Bloch', '1234567892');
