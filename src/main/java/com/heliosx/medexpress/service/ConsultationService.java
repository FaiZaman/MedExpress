package com.heliosx.medexpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.heliosx.medexpress.domain.enums.RejectionReason;
import com.heliosx.medexpress.domain.enums.Result;
import com.heliosx.medexpress.domain.model.AnswerModel;
import com.heliosx.medexpress.domain.model.ConsultationResultModel;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.domain.model.RejectionDetails;
import com.heliosx.medexpress.persistence.ConsultationDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final ConsultationDao consultationDao;

    public List<QuestionModel> getConsultationQuestions() {
        return consultationDao.getConsultationQuestions();
    }

    public ConsultationResultModel getConsultationResult(List<AnswerModel> answerModels) {
        List<QuestionModel> questionModels = consultationDao.getConsultationQuestions();
        Map<Long, QuestionModel> modelsByQuestionId = buildQuestionToModelMap(questionModels);

        List<RejectionReason> rejectionReasons = new ArrayList<>();

        answerModels.forEach(answerModel -> {
            Long questionId = answerModel.getQuestionId();
            QuestionModel questionModel = modelsByQuestionId.get(questionId);

            if (questionModel.getRejectionDetails() != null) {
                if (questionModel.getRejectionDetails().getRejectedAnswer().equals(answerModel.getAnswer())) {
                    rejectionReasons.add(questionModel.getRejectionDetails().getRejectionReason());
                }
            }
        });

        if (rejectionReasons.isEmpty()) {
            return ConsultationResultModel.builder()
                    .result(Result.APPROVED)
                    .build();
        } else {
            return ConsultationResultModel.builder()
                    .result(Result.REJECTED)
                    .rejectionReasons(rejectionReasons)
                    .build();
        }
    }

    private static Map<Long, QuestionModel> buildQuestionToModelMap(List<QuestionModel> questionModels) {
        return questionModels.stream()
                .collect(Collectors.toUnmodifiableMap(
                        QuestionModel::getQuestionId,
                        Function.identity()));
    }
}
