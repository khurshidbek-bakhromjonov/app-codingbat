package com.codingbat.controller;

import com.codingbat.dto.ResultDTO;
import com.codingbat.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService resultService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ResultDTO resultDTO) {
        return resultService.add(resultDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return resultService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return resultService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody ResultDTO resultDTO) {
        return resultService.edit(id, resultDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return resultService.delete(id);
    }

}
