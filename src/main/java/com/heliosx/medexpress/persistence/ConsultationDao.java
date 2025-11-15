package com.heliosx.medexpress.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heliosx.medexpress.domain.enums.AnswerType;
import com.heliosx.medexpress.domain.enums.RejectionReason;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.domain.model.RejectionDetails;

@Repository
public class ConsultationDao {

    private static final List<QuestionModel> QUESTIONS = List.of(
            QuestionModel.builder()
                    .questionId(1L)
                    .question("What is your first name?")
                    .answerType(AnswerType.STRING)
                    .build(),

            QuestionModel.builder()
                    .questionId(2L)
                    .question("What is your last name?")
                    .answerType(AnswerType.STRING)
                    .build(),

            QuestionModel.builder()
                    .questionId(3L)
                    .question("What is your email address?")
                    .answerType(AnswerType.STRING)
                    .build(),

            QuestionModel.builder()
                    .questionId(4L)
                    .question("What is your phone number?")
                    .answerType(AnswerType.STRING)
                    .build(),

            QuestionModel.builder()
                    .questionId(5L)
                    .question("What is your date of birth (DD/MM/YYYY)?")
                    .answerType(AnswerType.DATE)
                    .build(),

            QuestionModel.builder()
                    .questionId(6L)
                    .question("What is your height (in centimeters)?")
                    .answerType(AnswerType.NUMBER)
                    .build(),

            QuestionModel.builder()
                    .questionId(7L)
                    .question("What is your weight (in kilograms)?")
                    .answerType(AnswerType.NUMBER)
                    .build(),

            QuestionModel.builder()
                    .questionId(8L)
                    .question("Have you ever had an adverse reaction to Benadryl?")
                    .answerType(AnswerType.BOOLEAN)
                    .rejectionDetails(RejectionDetails.builder()
                            .rejectedAnswer("true")
                            .rejectionReason(RejectionReason.ADVERSE_REACTION)
                            .build())
                    .build()
    );

    public List<QuestionModel> getConsultationQuestions() {
        return QUESTIONS;
    }
}
