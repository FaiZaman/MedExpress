package com.heliosx.medexpress.domain.model;

import com.heliosx.medexpress.domain.dto.ConsultationResultDto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ConsultationResultModel {

    @NonNull
    private String result;

    private String reason;

    public ConsultationResultDto toConsultationResultDto() {
        return ConsultationResultDto.builder()
                .result(result)
                .reason(reason)
                .build();
    }
}
