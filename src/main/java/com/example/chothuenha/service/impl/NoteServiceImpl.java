package com.example.chothuenha.service.impl;

import com.example.chothuenha.model.Note;
import com.example.chothuenha.repository.NoteRepository;
import com.example.chothuenha.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).isPresent()?noteRepository.findById(id).get():null;
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Page<Note> findAllByNameOrContentContaining(Pageable pageable,String s) {
        return noteRepository.findAllByNameContaining(pageable,s);
    }
}
