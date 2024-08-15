package com.aikido.quiz.controller;

import com.aikido.quiz.Business.QuestionBusiness;
import com.aikido.quiz.entity.QuestionMO;
import com.aikido.quiz.entity.ResponseMO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionBusiness questionBusiness;

    @GetMapping("/list")
    public List<QuestionMO> getQuestionsWithResponses(){
        return questionBusiness.findQuestionsWithResponses();
    }

    @GetMapping("/{id}")
    public Optional<QuestionMO> getQuestionWithResponsesById(@PathVariable long id){
        return questionBusiness.findQuestionWithResponsesById(id);
    }

    @GetMapping("/random")
    public Optional<QuestionMO> getRandomQuestionWithResponsesById(){
        return questionBusiness.findRandomQuestionWithResponsesById();
    }

    @GetMapping("/response/{id}")
    public Set<ResponseMO> getResponseByQuestionId(@PathVariable long id){
        return questionBusiness.getResponseByQuestionId(id);
    }
}

