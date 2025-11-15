package com.heliosx.medexpress.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heliosx.medexpress.domain.enums.AnswerType;
import com.heliosx.medexpress.domain.model.QuestionModel;

@Repository
public class ConsultationDao {

    private final List<QuestionModel> questionModels = List.of(
            buildQuestionModel(1, "What is your first name?", AnswerType.STRING),
            buildQuestionModel(2, "What is your last name?", AnswerType.STRING),
            buildQuestionModel(3, "What is your email address?", AnswerType.EMAIL),
            buildQuestionModel(4, "What is your phone number?", AnswerType.PHONE),
            buildQuestionModel(5, "What is your date of birth (DD/MM/YYYY)?", AnswerType.DATE),
            buildQuestionModel(6, "What is your height (in centimeters)?", AnswerType.INTEGER),
            buildQuestionModel(7, "What is your weight (in kilograms)?", AnswerType.INTEGER),
            buildQuestionModel(8, "Have you ever had an adverse reaction to Benadryl?", AnswerType.BOOLEAN)
    );

    public List<QuestionModel> getConsultationQuestions() {
        return questionModels;
    }

    private static QuestionModel buildQuestionModel(int questionId, String question, AnswerType answerType) {
        return QuestionModel.builder()
                .questionId(questionId)
                .question(question)
                .answerType(answerType)
                .build();
    }
}
