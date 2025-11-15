package com.heliosx.medexpress.domain.model;

import com.heliosx.medexpress.domain.dto.QuestionDto;

import lombok.Builder;

@Builder
public class QuestionModel {

    private String question;

    public QuestionDto toQuestionDto() {
        return QuestionDto.builder()
                .question(question)
                .build();
    }
}
