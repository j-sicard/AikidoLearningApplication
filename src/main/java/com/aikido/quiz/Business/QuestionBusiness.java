package com.aikido.quiz.Business;

import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestionBusiness {
    public List<QuestionMO> findQuestionsWithResponses();

    public Optional<QuestionMO> findQuestionWithResponsesById(long id);

    public Optional<QuestionMO> findRandomQuestionWithResponsesById();

    public Set<ResponseMO> getResponseByQuestionId(long id);
}
