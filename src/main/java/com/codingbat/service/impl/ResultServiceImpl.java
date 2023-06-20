package com.codingbat.service.impl;

import com.codingbat.dto.ResultDTO;
import com.codingbat.entity.Result;
import com.codingbat.entity.Task;
import com.codingbat.entity.User;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.repository.ResultRepository;
import com.codingbat.repository.TaskRepository;
import com.codingbat.repository.UserRepository;
import com.codingbat.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(ResultDTO resultDTO) {
        Optional<User> user = userRepository.findById(resultDTO.getUserId());
        if (user.isEmpty())
            return ResponseEntity.status(404).body("User not found");

        Optional<Task> task = taskRepository.findById(resultDTO.getTaskId());
        if (task.isEmpty())
            return ResponseEntity.status(404).body("Task not found");

        resultRepository.save(mapstructMapper.toResult(resultDTO));
        return ResponseEntity.status(201).body(resultDTO);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(resultRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");
        return ResponseEntity.status(200).body(optionalResult.get());
    }

    @Override
    public ResponseEntity<?> edit(Long id, ResultDTO resultDTO) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");

        Optional<User> user = userRepository.findById(resultDTO.getUserId());
        if (user.isEmpty())
            return ResponseEntity.status(404).body("User not found");

        Optional<Task> task = taskRepository.findById(resultDTO.getTaskId());
        if (task.isEmpty())
            return ResponseEntity.status(404).body("Task not found");

        resultRepository.save(mapstructMapper.toResult(optionalResult.get(), resultDTO));
        return ResponseEntity.status(201).body(resultDTO);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if (optionalResult.isEmpty())
            return ResponseEntity.status(404).body("Result not found");
        resultRepository.delete(optionalResult.get());
        return ResponseEntity.status(200).body(mapstructMapper.toResultDTO(optionalResult.get()));
    }
}
