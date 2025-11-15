package com.heliosx.medexpress.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heliosx.medexpress.domain.dto.QuestionDto;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.service.ConsultationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping("/v1/consultation")
    public List<QuestionDto> getConsultationQuestions() {
        return consultationService.getConsultationQuestions().stream()
                .map(QuestionModel::toQuestionDto)
                .toList();
    }

}
