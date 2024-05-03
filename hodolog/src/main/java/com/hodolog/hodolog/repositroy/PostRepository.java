package com.hodolog.hodolog.repositroy;

import com.hodolog.hodolog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
