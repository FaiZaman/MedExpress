package com.heliosx.medexpress.domain.dto;

import com.heliosx.medexpress.domain.enums.AnswerType;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class QuestionDto {

    @NonNull
    private Long questionId;

    @NonNull
    private String question;

    @NonNull
    private AnswerType answerType;

}
