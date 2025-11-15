package com.heliosx.medexpress.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


import com.heliosx.medexpress.domain.enums.AnswerType;
import com.heliosx.medexpress.domain.enums.RejectionReason;
import com.heliosx.medexpress.domain.enums.Result;
import com.heliosx.medexpress.domain.model.AnswerModel;
import com.heliosx.medexpress.domain.model.ConsultationResultModel;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.domain.model.RejectionDetails;
import com.heliosx.medexpress.persistence.ConsultationDao;

@ExtendWith(MockitoExtension.class)
class ConsultationServiceTest {

    @Mock
    private ConsultationDao consultationDao;

    @InjectMocks
    private ConsultationService consultationService;

    @Test
    void shouldApproveConsultationIfQuestionHasNoRejections() {
        List<QuestionModel> questionModel = List.of(QuestionModel.builder()
                .questionId(1L)
                .question("What is your first name?")
                .answerType(AnswerType.STRING)
                .build());

        List<AnswerModel> answerModel = List.of(AnswerModel.builder()
                .questionId(1L)
                .answer("John")
                .build());

        when(consultationDao.getConsultationQuestions()).thenReturn(questionModel);

        ConsultationResultModel expectedConsultationResultModel = ConsultationResultModel.builder()
                .result(Result.APPROVED)
                .build();

        ConsultationResultModel actualConsultationResultModel = consultationService.getConsultationResult(answerModel);
        assertThat(actualConsultationResultModel).isEqualTo(expectedConsultationResultModel);
    }

    @Test
    void shouldApproveConsultationIfNoRejectedAnswers() {
        List<QuestionModel> questionModel = List.of(QuestionModel.builder()
                .questionId(8L)
                .question("Have you ever had an adverse reaction to Benadryl?")
                .answerType(AnswerType.BOOLEAN)
                .rejectionDetails(RejectionDetails.builder()
                        .rejectedAnswer("true")
                        .rejectionReason(RejectionReason.ADVERSE_REACTION)
                        .build())
                .build());

        List<AnswerModel> answerModel = List.of(AnswerModel.builder()
                .questionId(8L)
                .answer("false")
                .build());

        when(consultationDao.getConsultationQuestions()).thenReturn(questionModel);

        ConsultationResultModel expectedConsultationResultModel = ConsultationResultModel.builder()
                .result(Result.APPROVED)
                .build();

        ConsultationResultModel actualConsultationResultModel = consultationService.getConsultationResult(answerModel);
        assertThat(actualConsultationResultModel).isEqualTo(expectedConsultationResultModel);
    }

    @Test
    void shouldRejectConsultationWithReasonIfRejectedAnswer() {
        List<QuestionModel> questionModel = List.of(QuestionModel.builder()
                .questionId(8L)
                .question("Have you ever had an adverse reaction to Benadryl?")
                .answerType(AnswerType.BOOLEAN)
                .rejectionDetails(RejectionDetails.builder()
                        .rejectedAnswer("true")
                        .rejectionReason(RejectionReason.ADVERSE_REACTION)
                        .build())
                .build());

        List<AnswerModel> answerModel = List.of(AnswerModel.builder()
                .questionId(8L)
                .answer("true")
                .build());

        when(consultationDao.getConsultationQuestions()).thenReturn(questionModel);

        ConsultationResultModel expectedConsultationResultModel = ConsultationResultModel.builder()
                .result(Result.REJECTED)
                .rejectionReasons(List.of(RejectionReason.ADVERSE_REACTION))
                .build();

        ConsultationResultModel actualConsultationResultModel = consultationService.getConsultationResult(answerModel);
        assertThat(actualConsultationResultModel).isEqualTo(expectedConsultationResultModel);
    }

}
