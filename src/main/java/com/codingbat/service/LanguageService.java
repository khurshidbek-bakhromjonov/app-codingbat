package com.codingbat.service;

import com.codingbat.dto.LanguageDTO;
import org.springframework.http.ResponseEntity;

public interface LanguageService {

    ResponseEntity<?> add(LanguageDTO languageDTO);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> edit(Long id, LanguageDTO languageDTO);

    ResponseEntity<?> delete(Long id);
}
