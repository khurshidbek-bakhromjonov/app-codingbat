package com.codingbat.service.impl;

import com.codingbat.dto.LanguageDTO;
import com.codingbat.entity.Language;
import com.codingbat.mapper.MapstructMapper;
import com.codingbat.repository.LanguageRepository;
import com.codingbat.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final MapstructMapper mapstructMapper;

    @Override
    public ResponseEntity<?> add(LanguageDTO languageDTO) {
        languageRepository.save(mapstructMapper.toLanguage(languageDTO));
        return ResponseEntity.status(201).body(languageDTO);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(languageRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        return ResponseEntity.status(200).body(optionalLanguage.get());
    }

    @Override
    public ResponseEntity<?> edit(Long id, LanguageDTO languageDTO) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        languageRepository.save(mapstructMapper.toLanguage(optionalLanguage.get(), languageDTO));
        return ResponseEntity.status(201).body(languageDTO);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isEmpty())
            return ResponseEntity.status(404).body("Language not found");
        languageRepository.delete(optionalLanguage.get());
        return ResponseEntity.status(200).body(mapstructMapper.toLanguageDTO(optionalLanguage.get()));
    }
}
