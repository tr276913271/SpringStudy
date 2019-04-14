package me.kagami.jpa.studyjpa.repository;

import me.kagami.jpa.studyjpa.bean.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
