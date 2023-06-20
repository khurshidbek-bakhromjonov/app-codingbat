package com.codingbat.controller;

import com.codingbat.dto.LanguageDTO;
import com.codingbat.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody LanguageDTO languageDTO) {
        return languageService.add(languageDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        return languageService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Long id, @RequestBody LanguageDTO languageDTO) {
        return languageService.edit(id, languageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return languageService.delete(id);
    }
}
