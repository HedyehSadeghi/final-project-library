--import libri--
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a whale', 'https://m.media-amazon.com/images/I/71d5wo+-MuL._AC_UF1000,1000_QL80_.jpg', 10.50, 'Moby Dick');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://m.media-amazon.com/images/I/911370CYBTL._AC_UF1000,1000_QL80_.jpg', 12.50, 'Harry Potter - Prisoner of Azkaban');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://m.media-amazon.com/images/I/71sH3vxziLL._AC_UF1000,1000_QL80_.jpg', 13, 'Harry Potter - Deathly Hallows');

--import client purchases--
INSERT INTO db_final_library.client_purchases(amount, `date`, price, book_id_client_id)VALUES( 5, '2024-01-24', 76.80,1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, price, book_id_client_id)VALUES( 15, '2024-01-24', 160.32,2 );
INSERT INTO db_final_library.client_purchases(amount, `date`, price, book_id_client_id)VALUES( 2, '2024-01-24', 40.1,1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, price, book_id_client_id)VALUES( 31, '2024-01-24', 450.23,2);


--import categories--
INSERT INTO db_final_library.categories( name)VALUES('Bambini e Ragazzi');
INSERT INTO db_final_library.categories( name)VALUES('Gialli e Thriller');
INSERT INTO db_final_library.categories( name)VALUES('Narrativa Straniera');
INSERT INTO db_final_library.categories( name)VALUES('Fantasia e Fantascienza');
INSERT INTO db_final_library.categories( name)VALUES('Religione e Spiritualità');
INSERT INTO db_final_library.categories( name)VALUES('Psicologia');


--import categories-books--
INSERT INTO db_final_library.categories_book_list(category_list_id, book_list_id)VALUES(1, 1);




--import supplier--
INSERT INTO db_final_library.suppliers(name)VALUES('Mondadori');


--import supplier-book-purchases --
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id_id, supplier_id_id)VALUES(50, '2023-12-20', 200.0, 2, 1);
