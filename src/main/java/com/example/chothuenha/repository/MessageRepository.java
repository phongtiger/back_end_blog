package com.example.chothuenha.repository;

import com.example.chothuenha.model.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageRepository extends PagingAndSortingRepository<Message,Long> {
    Iterable<Message> findAllByUserIdAndFriendId(Long user,Long friend);
}
