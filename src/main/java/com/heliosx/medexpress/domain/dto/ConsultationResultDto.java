package com.heliosx.medexpress.domain.dto;

import com.heliosx.medexpress.domain.enums.RejectionReason;
import com.heliosx.medexpress.domain.enums.Result;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ConsultationResultDto {

    @NonNull
    private Result result;

    private RejectionReason rejectionReason;
}
