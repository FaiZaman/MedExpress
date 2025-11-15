package com.heliosx.medexpress.domain.dto;

import com.heliosx.medexpress.domain.model.AnswerModel;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AnswerDto {

    @NonNull
    private Long questionId;

    @NonNull
    private String answer;

    public AnswerModel toAnswerModel() {
        return AnswerModel.builder()
                .questionId(questionId)
                .answer(answer)
                .build();
    }
}
