package org.learning.finalprojectlibrary.repository;

import org.learning.finalprojectlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String searchKeyword);

    // Trova tutti i libri di una data categoria ordinati per numero di acquisti dei clienti
    @Query("SELECT b FROM Book b JOIN b.categoryList c JOIN b.clientPurchases cp WHERE c.name = :categoryName GROUP BY b ORDER BY COUNT(cp) DESC")
    List<Book> findBestSellersByCategory(@Param("categoryName") String categoryName);
}
