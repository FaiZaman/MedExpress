package com.heliosx.medexpress.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heliosx.medexpress.domain.dto.AnswerDto;
import com.heliosx.medexpress.domain.dto.ConsultationResultDto;
import com.heliosx.medexpress.domain.dto.QuestionDto;
import com.heliosx.medexpress.domain.model.AnswerModel;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.service.ConsultationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping(value = "/v1/consultation", produces = APPLICATION_JSON_VALUE)
    public List<QuestionDto> getConsultationQuestions() {
        return consultationService.getConsultationQuestions().stream()
                .map(QuestionModel::toQuestionDto)
                .toList();
    }

    @PostMapping(value = "/v1/consultation-result", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ConsultationResultDto getConsultationResult(@RequestBody List<AnswerDto> answerDtos) {
        List<AnswerModel> answerModels = answerDtos.stream()
                .map(AnswerDto::toAnswerModel)
                .toList();

        return consultationService.getConsultationResult(answerModels).toConsultationResultDto();
    }

}
