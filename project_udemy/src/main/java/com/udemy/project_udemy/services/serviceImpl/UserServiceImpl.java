package com.udemy.project_udemy.services.serviceImpl;

import com.udemy.project_udemy.entities.User;
import com.udemy.project_udemy.enums.PEnum;
import com.udemy.project_udemy.repositories.UserRepository;
import com.udemy.project_udemy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.udemy.project_udemy.enums.PEnum.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public ResponseEntity<?> addUser(User user) {
        HashMap<PEnum,Object> hashMap =new HashMap<>();
        boolean hasUserName =userRepository.existsByUserName(user.getUserName());
        if (hasUserName){
            hashMap.put(status,false);
            hashMap.put(error,"Already exist user");

            hashMap.put(username,user.getUserName());
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        hashMap.put(status,true);
        hashMap.put(message,"Created User");
        hashMap.put(username,user.getUserName());
        return new ResponseEntity<>(hashMap,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> findUser(Long id) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            hashMap.put(status,true);
            hashMap.put(result,user);
            return new ResponseEntity<>(hashMap,HttpStatus.OK);

        }
        hashMap.put(status,false);
        hashMap.put(error,"Not Found User With " + id );

        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteuser(Long id) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        boolean hasUser = userRepository.existsById(id);
        if (hasUser){
            userRepository.deleteById(id);
            hashMap.put(status,true);
            hashMap.put(message,"User is Deleted");
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }
        hashMap.put(status,false);
        hashMap.put(error,"Not found User");

        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        Optional<User> optionalUser = userRepository.findById(user.getId());

        if(optionalUser.isPresent()){
            userRepository.saveAndFlush(user);
            hashMap.put(status,true);
            hashMap.put(message,"Updated Ok");
            hashMap.put(username,user.getUserName());
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }
        hashMap.put(status,false);
        hashMap.put(error,"User is null");
        hashMap.put(username,user.getUserName());
        return new ResponseEntity<>(hashMap,HttpStatus.NOT_FOUND);
    }




}
