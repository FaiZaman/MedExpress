package com.heliosx.medexpress.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heliosx.medexpress.domain.model.QuestionModel;

@Repository
public class ConsultationDao {

    private final List<QuestionModel> questionModels = List.of(
            buildQuestionModel("What is your first name?"),
            buildQuestionModel("What is your last name?"),
            buildQuestionModel("What is your email address?"),
            buildQuestionModel("What is your phone number?"),
            buildQuestionModel("What is your date of birth (DD/MM/YYYY)?"),
            buildQuestionModel("What is your height (in centimeters)?"),
            buildQuestionModel("What is your weight (in kilograms)?"),
            buildQuestionModel("Have you ever had an adverse reaction to Benadryl?")
    );

    public List<QuestionModel> getConsultationQuestions() {
        return questionModels;
    }

    private static QuestionModel buildQuestionModel(String question) {
        return QuestionModel.builder()
                .question(question)
                .build();
    }
}
