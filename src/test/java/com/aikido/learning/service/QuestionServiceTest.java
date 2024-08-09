package com.aikido.learning.service;

import com.aikido.quiz.AikidoQuizApplication;
import com.aikido.quiz.service.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AikidoQuizApplication.class)
@TestPropertySource(locations="classpath:application-test.properties")
@Transactional
public class QuestionServiceTest {
    @Autowired
    QuestionService questionService;

    // -- findQuestions tests --//
    @Test
    @Transactional
    void findQuestionsTest() {
        assertTrue(questionService.findQuestions().size() > 0);
    }

    // -- findQuestionByID Tests -- //
    @Test
    void findQuestionByIDIsPresentTest(){
        assertTrue(questionService.findQuestionByID(1L).isPresent());
    }

    @Test
    void findQuestionByIDSuccessTest(){
        assertTrue(questionService.findQuestionByID(1L).get().getQuestionState().equals("TACHI WAZA"));
    }

    @Test
    void findQuestionByIDFailureTest(){
        assertTrue(questionService.findQuestionByID(0L).isEmpty());
    }

    // -- findResponseByQuestionId Tests -- //



}

