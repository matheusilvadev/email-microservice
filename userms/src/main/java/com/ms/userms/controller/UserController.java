package com.ms.userms.controller;

import com.ms.userms.controller.dto.CreateUserDTO;
import com.ms.userms.model.User;
import com.ms.userms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid CreateUserDTO dto){

        var nwUser = new User();
        BeanUtils.copyProperties(dto, nwUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nwUser));

    }


}
