package com.heliosx.medexpress.domain.model;

import java.util.List;

import com.heliosx.medexpress.domain.dto.ConsultationResultDto;
import com.heliosx.medexpress.domain.enums.RejectionReason;
import com.heliosx.medexpress.domain.enums.Result;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ConsultationResultModel {

    @NonNull
    private Result result;

    private List<RejectionReason> rejectionReasons;

    public ConsultationResultDto toConsultationResultDto() {
        return ConsultationResultDto.builder()
                .result(result)
                .rejectionReasons(rejectionReasons)
                .build();
    }
}
