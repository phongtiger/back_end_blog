package com.example.chothuenha.service;

import com.example.chothuenha.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    Page<Message> findAll(Pageable pageable);
    Message findById(Long id);
    void save(Message message);
    void delete(Long id);
    Iterable<Message> findMessage(Long a, Long b);
}
