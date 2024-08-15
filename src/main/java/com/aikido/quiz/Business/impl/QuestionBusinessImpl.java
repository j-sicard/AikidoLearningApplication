package com.aikido.quiz.Business.impl;

import com.aikido.quiz.Business.QuestionBusiness;
import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;
import com.aikido.quiz.service.QuestionService;
import com.aikido.quiz.utils.RandomNumberManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionBusinessImpl implements QuestionBusiness {

    private static final Logger logger = LoggerFactory.getLogger(QuestionBusinessImpl.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    RandomNumberManager randomNumberManager;

    public List<QuestionMO> findQuestionsWithResponses(){
        List<QuestionMO> questions = questionService.findQuestions();
        logger.info("Fetched questions: {}", questions);
        return questions;
    }

    public Optional<QuestionMO> findQuestionWithResponsesById(long id){
        return questionService.findQuestionByID(id);
    }

    public Optional<QuestionMO> findRandomQuestionWithResponsesById(){
        return questionService.findQuestionByID(randomNumberManager.generateRandomInt());
    }

    public Set<ResponseMO> getResponseByQuestionId(long id){
        return questionService.findResponseByQuestionId(id);
    }
}
