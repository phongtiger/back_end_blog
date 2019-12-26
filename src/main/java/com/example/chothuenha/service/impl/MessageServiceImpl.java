package com.example.chothuenha.service.impl;

import com.example.chothuenha.model.Message;
import com.example.chothuenha.repository.MessageRepository;
import com.example.chothuenha.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);

    }

    @Override
    public Iterable<Message> findMessage(Long a, Long b) {
        return messageRepository.findAllByUserIdAndFriendId(a,b);
    }
}
