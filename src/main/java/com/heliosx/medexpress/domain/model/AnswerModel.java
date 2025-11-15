package com.heliosx.medexpress.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AnswerModel {

    @NonNull
    private Long questionId;

    @NonNull
    private String answer;

}
