CREATE TABLE BOOKS (
  ID INT NOT NULL AUTO_INCREMENT,
  BOOK_TITLE VARCHAR(255) collate utf8_swedish_ci default NULL,
  BOOK_AUTHOR VARCHAR(255) collate utf8_swedish_ci default NULL,
  BOOK_PRICE INT NOT NULL,
  PRIMARY KEY (ID)
)
  DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci ROW_FORMAT=DYNAMIC
;