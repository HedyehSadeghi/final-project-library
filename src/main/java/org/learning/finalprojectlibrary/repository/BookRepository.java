package org.learning.finalprojectlibrary.repository;

import org.learning.finalprojectlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String searchKeyword);


}
