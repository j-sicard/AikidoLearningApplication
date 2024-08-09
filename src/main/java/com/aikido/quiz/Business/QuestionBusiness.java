package com.aikido.quiz.Business;

import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionBusiness {
    public List<QuestionMO> getQuestions();

    public Optional<QuestionMO> getQuestionById(long id);

    public Optional<QuestionMO> getRandomQuestion();

    public Set<ResponseMO> getResponsesByQuestionId(long id);
}
