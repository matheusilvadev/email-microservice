package com.ms.userms.service;

import com.ms.userms.model.User;
import com.ms.userms.producer.UserProducer;
import com.ms.userms.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserProducer producer;

    @Transactional
    public User save(User user){

        var userToSave = repository.save(user);
        producer.publishMessageEmail(userToSave);

        return userToSave;
    }

}
