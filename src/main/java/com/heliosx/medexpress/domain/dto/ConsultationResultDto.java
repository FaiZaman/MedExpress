package com.heliosx.medexpress.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ConsultationResultDto {

    @NonNull
    private String result;

    private String reason;
}
