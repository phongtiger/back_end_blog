package com.example.chothuenha.repository;

import com.example.chothuenha.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Page<Note> findAllByNameContaining(Pageable pageable,String string);
}
