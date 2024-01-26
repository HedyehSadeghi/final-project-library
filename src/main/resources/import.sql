--import libri--
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a whale', 'https://m.media-amazon.com/images/I/71d5wo+-MuL._AC_UF1000,1000_QL80_.jpg', 10.50, 'Moby Dick');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://m.media-amazon.com/images/I/91VZqV0Cy8L._AC_UF1000,1000_QL80_.jpg', 12.50, 'Harry Potter - Prisoner of Azkaban');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://m.media-amazon.com/images/I/71sH3vxziLL._AC_UF1000,1000_QL80_.jpg', 13, 'Harry Potter - Deathly Hallows');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://upload.wikimedia.org/wikipedia/en/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg', 14, 'Harry Potter - Order of Phoenix');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png', 13, 'Harry Potter - Half-Blood Prince');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Agile software', 'https://m.media-amazon.com/images/I/51E2055ZGUL._SY466_.jpg', 29, 'Clean Code');

--import client purchases--
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 5, '2024-01-24',1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 15, '2024-01-24', 2 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 2, '2024-01-24', 1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 31, '2024-01-24',2);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 14, '2024-01-20', 4);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 29, '2024-01-19', 5);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 39, '2024-01-18',1);


--import categories--
INSERT INTO db_final_library.categories( name)VALUES('Bambini e Ragazzi');
INSERT INTO db_final_library.categories( name)VALUES('Gialli e Thriller');
INSERT INTO db_final_library.categories( name)VALUES('Narrativa Straniera');
INSERT INTO db_final_library.categories( name)VALUES('Fantasia e Fantascienza');
INSERT INTO db_final_library.categories( name)VALUES('Religione e Spiritualità');
INSERT INTO db_final_library.categories( name)VALUES('Psicologia');
INSERT INTO db_final_library.categories( name)VALUES('Narrativa');


--import categories-books--
INSERT INTO db_final_library.categories_book_list(category_list_id, book_list_id)VALUES(1, 1);
INSERT INTO db_final_library.categories_book_list(category_list_id, book_list_id)VALUES(4, 3);
INSERT INTO db_final_library.categories_book_list(category_list_id, book_list_id)VALUES(4, 4);
INSERT INTO db_final_library.categories_book_list(category_list_id, book_list_id)VALUES(1, 2);





--import supplier--
INSERT INTO db_final_library.suppliers(name)VALUES('Mondadori');
INSERT INTO db_final_library.suppliers(name)VALUES('Feltrinelli');
INSERT INTO db_final_library.suppliers(name)VALUES('Fabbri');
INSERT INTO db_final_library.suppliers(name)VALUES('Penguin');
INSERT INTO db_final_library.suppliers(name)VALUES('Giunti');
INSERT INTO db_final_library.suppliers(name)VALUES('Einaudi');
INSERT INTO db_final_library.suppliers(name)VALUES('Bompiani');


--import supplier-book-purchases --
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(50, '2023-12-20', 399, 2, 1);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(70, '2023-12-10', 588.6, 1, 1);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(50, '2023-12-13', 325, 1, 1);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(149, '2023-12-11', 1189.02, 2, 1);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(59, '2023-12-29', 500, 3, 2);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(43, '2023-12-29', 499, 4, 3);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(68, '2023-12-29', 589.3, 5, 4);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(69, '2023-12-29', 689.45, 6, 5);
