package com.codingbat.service;

import com.codingbat.dto.TaskDTO;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    ResponseEntity<?> add(TaskDTO taskDTO);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> edit(Long id, TaskDTO taskDTO);

    ResponseEntity<?> delete(Long id);
}
