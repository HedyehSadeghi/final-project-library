package org.learning.finalprojectlibrary.repository;

import org.learning.finalprojectlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
