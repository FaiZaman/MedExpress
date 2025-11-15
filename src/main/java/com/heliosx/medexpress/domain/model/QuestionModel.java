package com.heliosx.medexpress.domain.model;

import com.heliosx.medexpress.domain.dto.QuestionDto;
import com.heliosx.medexpress.domain.enums.AnswerType;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class QuestionModel {

    @NonNull
    Long questionId;

    @NonNull
    String question;

    @NonNull
    AnswerType answerType;

    RejectionDetails rejectionDetails;

    public QuestionDto toQuestionDto() {
        return QuestionDto.builder()
                .questionId(questionId)
                .question(question)
                .answerType(answerType)
                .build();
    }
}
