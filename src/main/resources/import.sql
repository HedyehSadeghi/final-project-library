--import libri--
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a whale', 'https://m.media-amazon.com/images/I/71d5wo+-MuL._AC_UF1000,1000_QL80_.jpg', 10.50, 'Moby Dick');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard', 'https://m.media-amazon.com/images/I/91VZqV0Cy8L._AC_UF1000,1000_QL80_.jpg', 12.50, 'Harry Potter - Prisoner of Azkaban');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard', 'https://m.media-amazon.com/images/I/71sH3vxziLL._AC_UF1000,1000_QL80_.jpg', 13, 'Harry Potter - Deathly Hallows');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard', 'https://upload.wikimedia.org/wikipedia/en/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg', 14, 'Harry Potter - Order of Phoenix');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('tale about a wizard', 'https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png', 13, 'Harry Potter - Half-Blood Prince');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Agile software', 'https://m.media-amazon.com/images/I/51E2055ZGUL._SY466_.jpg', 29, 'Clean Code');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Dystopian novella by George Orwell','https://m.media-amazon.com/images/I/81StSOpmkjL._AC_UF1000,1000_QL80_.jpg',11.99,'1984');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard','https://libreriavitaepensiero.mediabiblos.it/copertine/salani/harry-potter-e-la-pietra-filosofale-ediz-anniversario-25-anni-9788831017329.jpg',9.50,'Harry Potter - Philosopher\'s stone');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard','https://m.media-amazon.com/images/I/81gOJoEgVoL._AC_UF1000,1000_QL80_.jpg',10.75,'Harry Potter - Chamber of secrets');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Tale about a wizard','https://m.media-amazon.com/images/I/81sUIr3c1pL._AC_UF1000,1000_QL80_.jpg',13.95,'Harry potter - Goblet of fire');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Young adult novel','https://www.leggendoleggendo.it/wp-content/uploads/2020/01/9788817154369.jpg',8.40,'Quando Hitler rubò il coniglio rosa');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Children\'s novel','https://m.media-amazon.com/images/I/711cPWrJXRL._AC_UF1000,1000_QL80_.jpg',29.90,'Alice\'s adventures in Wonderland');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Mystery thriller novel','https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1463592438i/30228538.jpg',14.72,'The Da Vinci code');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Post-apocalyptic novel','https://www.ibs.it/images/9788858831939_0_536_0_75.jpg',11.40,'Cecità');
INSERT INTO db_final_library.books(description, photo, price, title)VALUES('Bildungsroman','https://emonsaudiolibri.it/media/images/cover/lamica-geniale-201.jpg',18.05,'L\'amica geniale');

--import client purchases--
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 5, '2024-01-24',1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 15, '2024-01-24', 2 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 2, '2024-01-24', 1 );
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 31, '2024-01-24',2);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 14, '2024-01-20', 4);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 29, '2024-01-19', 5);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 39, '2023-02-18',10);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 40, '2023-04-15',9);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 69, '2024-01-26',8);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 72, '2023-11-25',11);
INSERT INTO db_final_library.client_purchases(amount, `date`, book_id)VALUES( 84, '2023-08-07',14);



--import categories--
INSERT INTO db_final_library.categories( name)VALUES('Bambini e Ragazzi');
INSERT INTO db_final_library.categories( name)VALUES('Gialli e Thriller');
INSERT INTO db_final_library.categories( name)VALUES('Narrativa Straniera');
INSERT INTO db_final_library.categories( name)VALUES('Fantasia e Fantascienza');
INSERT INTO db_final_library.categories( name)VALUES('Religione e Spiritualità');
INSERT INTO db_final_library.categories( name)VALUES('Psicologia');
INSERT INTO db_final_library.categories( name)VALUES('Storico');
INSERT INTO db_final_library.categories( name)VALUES('Umoristico');
INSERT INTO db_final_library.categories( name)VALUES('Horror');


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
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(75, '2023-11-11', 689.45, 6, 5);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(35, '2023-08-29', 419.65, 7, 7);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(48, '2023-07-22', 547.2, 14, 2);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(97, '2023-12-29', 863.3, 11, 3);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(66, '2023-03-12', 920.7, 10, 5);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(15, '2023-12-01', 142.25, 8, 4);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(47, '2023-05-10', 691.84, 13, 2);
INSERT INTO db_final_library.supplier_book_purchases(amount, `date`, price, book_id, supplier_id)VALUES(140,'2023-02-28', 4186, 12, 1);
