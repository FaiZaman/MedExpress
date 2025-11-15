package com.heliosx.medexpress.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.heliosx.medexpress.dto.QuestionDto;

@Service
public class ConsultationService {

    public List<QuestionDto> getConsultationQuestions() {
        return List.of(QuestionDto.builder()
                .question("What is your name?")
                .build());
    }

}
