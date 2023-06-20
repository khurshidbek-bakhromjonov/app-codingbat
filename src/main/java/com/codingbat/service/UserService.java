package com.codingbat.service;

import com.codingbat.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> register(UserDTO userDTO);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> edit(Long id, UserDTO userDTO);

    ResponseEntity<?> delete(Long id);
}
