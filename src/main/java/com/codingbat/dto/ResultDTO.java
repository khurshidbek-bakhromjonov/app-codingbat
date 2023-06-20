package com.codingbat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private Long userId;

    private Long taskId;

    private String responseResult;

    private boolean isCorrect;
}
