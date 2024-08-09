package com.aikido.quiz.service;

import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionService {
    public List<QuestionMO> findQuestions();

    public Optional<QuestionMO> findQuestionByID(long id);

    public Set<ResponseMO> findResponseByQuestionId(long id);
}
