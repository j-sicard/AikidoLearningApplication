package com.aikido.quiz.service.impl;

import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;
import com.aikido.quiz.repositoriy.QuestionRepository;
import com.aikido.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<QuestionMO> findQuestions(){
        return questionRepository.findAll();
    }

    public Optional<QuestionMO> findQuestionByID(long id){
        return questionRepository.findById(id);
    }

    public Set<ResponseMO> findResponseByQuestionId(long id){
        Set<ResponseMO> responces = questionRepository.findById(id).get().getResponses();
        return responces;
    }
}
