package com.heliosx.medexpress.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.heliosx.medexpress.domain.model.QuestionModel;
import com.heliosx.medexpress.persistence.ConsultationDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final ConsultationDao consultationDao;

    public List<QuestionModel> getConsultationQuestions() {
        return consultationDao.getConsultationQuestions();
    }

}
