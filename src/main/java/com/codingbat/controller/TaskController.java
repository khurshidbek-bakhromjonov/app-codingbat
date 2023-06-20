package com.codingbat.controller;

import com.codingbat.dto.TaskDTO;
import com.codingbat.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TaskDTO taskDTO) {
        return taskService.add(taskDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return taskService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.edit(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return taskService.delete(id);
    }
}
