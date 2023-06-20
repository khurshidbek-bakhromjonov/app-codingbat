package com.codingbat.service.impl;

import com.codingbat.dto.TaskDTO;
import com.codingbat.entity.Language;
import com.codingbat.entity.Task;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.repository.LanguageRepository;
import com.codingbat.repository.TaskRepository;
import com.codingbat.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final LanguageRepository languageRepository;
    private final TaskRepository taskRepository;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(TaskDTO taskDTO) {
        Optional<Language> optionalLanguage = languageRepository.findById(taskDTO.getLanguageId());
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        taskRepository.save(mapstructMapper.toTask(taskDTO));
        return ResponseEntity.status(201).body(taskDTO);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(taskRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        return ResponseEntity.status(200).body(optionalTask.get());
    }

    @Override
    public ResponseEntity<?> edit(Long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        Optional<Language> optionalLanguage = languageRepository.findById(taskDTO.getLanguageId());
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        taskRepository.save(mapstructMapper.toTask(optionalTask.get(), taskDTO));
        return ResponseEntity.status(201).body(taskDTO);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity.status(404).body("Task not found");
        taskRepository.delete(optionalTask.get());
        return ResponseEntity.status(200).body(mapstructMapper.toTaskDTO(optionalTask.get()));
    }
}
