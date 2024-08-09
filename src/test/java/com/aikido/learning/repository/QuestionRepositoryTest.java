package com.aikido.learning.repository;

import com.aikido.quiz.AikidoQuizApplication;
import com.aikido.quiz.repositoriy.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AikidoQuizApplication.class)
@TestPropertySource(locations="classpath:application-test.properties")
@Transactional
public class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    // -- findQuestions tests --//
    @Test
    void findQuestionsTest(){
        assertTrue(questionRepository.findAll().size() > 0);
    }

    // -- findQuestionById tests --//
    @Test
    void findQuestionByIdIsPresentTest(){
        assertTrue(questionRepository.findById(1L).isPresent());
    }

    @Test
    void findQuestionByIdSuccessTest(){
        assertTrue(questionRepository.findById(1L).get().getQuestionState().equals("TACHI WAZA"));
    }

    @Test
    void findQuestionByIdFailureTest(){
        assertTrue(questionRepository.findById(0L).isEmpty());
    }

}

