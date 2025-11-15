package com.heliosx.medexpress.domain.model;

import com.heliosx.medexpress.domain.dto.QuestionDto;
import com.heliosx.medexpress.domain.enums.AnswerType;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class QuestionModel {

    @NonNull
    private Long questionId;

    @NonNull
    private String question;

    @NonNull
    private AnswerType answerType;

    private String rejectedAnswer;

    public QuestionDto toQuestionDto() {
        return QuestionDto.builder()
                .questionId(questionId)
                .question(question)
                .answerType(answerType)
                .build();
    }
}
