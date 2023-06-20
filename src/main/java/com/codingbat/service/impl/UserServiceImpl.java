package com.codingbat.service.impl;

import com.codingbat.dto.UserDTO;
import com.codingbat.entity.User;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.repository.UserRepository;
import com.codingbat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> register(UserDTO userDTO) {
        userRepository.save(mapstructMapper.toUser(userDTO));
        return ResponseEntity.status(201).body(userDTO);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(userRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        return ResponseEntity.status(200).body(optionalUser.get());
    }

    @Override
    public ResponseEntity<?> edit(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        userRepository.save(mapstructMapper.toUser(optionalUser.get(), userDTO));
        return ResponseEntity.status(201).body(userDTO);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.status(404).body("User not found");
        userRepository.delete(optionalUser.get());
        return ResponseEntity.status(200).body(mapstructMapper.toUserDTO(optionalUser.get()));
    }
}
