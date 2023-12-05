package com.learning.springboot.controller;

//import com.learning.springboot.entity.User;
//import com.learning.springboot.service.UserService;
import com.learning.springboot.dto.UserDto;
import com.learning.springboot.entity.User;
import com.learning.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{userId}")
        public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
            UserDto getUser = userService.getUserById(userId);
            return ResponseEntity.ok(getUser);
        }

     @GetMapping("/findAll")
        public ResponseEntity<List<UserDto>> getAllUsers(){
            List<UserDto> getUsers = userService.getAllUsers();
            return ResponseEntity.ok(getUsers);
     }

     @PutMapping("/update/{id}")
        public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
            userDto.setId(id);
            UserDto updatedUser = userService.updateUser(userDto);
            return ResponseEntity.ok(updatedUser);
     }

     @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return new ResponseEntity<>("user deleted" , HttpStatus.CREATED);

     }
}


