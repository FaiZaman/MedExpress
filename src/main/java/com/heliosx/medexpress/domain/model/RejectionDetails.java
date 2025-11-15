package com.heliosx.medexpress.domain.model;

import com.heliosx.medexpress.domain.enums.RejectionReason;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class RejectionDetails {

    @NonNull
    String rejectedAnswer;

    @NonNull
    RejectionReason rejectionReason;
}
