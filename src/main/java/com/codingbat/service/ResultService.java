package com.codingbat.service;

import com.codingbat.dto.ResultDTO;
import org.springframework.http.ResponseEntity;

public interface ResultService {

    ResponseEntity<?> add(ResultDTO resultDTO);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> edit(Long id, ResultDTO resultDTO);

    ResponseEntity<?> delete(Long id);
}
