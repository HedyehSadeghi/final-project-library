package org.learning.finalprojectlibrary.repository;

import org.learning.finalprojectlibrary.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {

    Optional<LibraryUser> findByEmail(String email);
}
