package com.learning.springboot.service;

import com.learning.springboot.dto.UserDto;
import com.learning.springboot.entity.User;

import java.util.List;


public interface UserService {
     UserDto createUser(UserDto user);

     UserDto getUserById(Long userId);

     List<UserDto> getAllUsers();

     UserDto updateUser(UserDto user);

     void deleteUser(Long userId);
}
