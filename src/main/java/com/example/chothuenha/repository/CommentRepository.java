package com.example.chothuenha.repository;

import com.example.chothuenha.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
}
