package com.phenol.bookservice.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phenol.bookservice.Entity.Books;

import java.util.List;

@Repository
public interface LibRepository extends JpaRepository<Books, Integer> {
    //List<Books> findByYear(int year);

    List<Books> findByAuthorName(String authorName);

    List<Books> findByTitle(String title);
}
