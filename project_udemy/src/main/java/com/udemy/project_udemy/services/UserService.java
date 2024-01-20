package com.udemy.project_udemy.services;

import com.udemy.project_udemy.entities.User;
import com.udemy.project_udemy.enums.PEnum;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    public ResponseEntity<?> addUser(User user);
    public ResponseEntity<?> findUser(Long id);

    public ResponseEntity<?> deleteuser(Long id);
   public ResponseEntity<?> updateUser(User user);



}
