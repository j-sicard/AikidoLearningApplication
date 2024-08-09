package com.aikido.learning.business;

import com.aikido.quiz.AikidoQuizApplication;
import com.aikido.quiz.Business.QuestionBusiness;
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
public class QuestionBusinessTest {

    @Autowired
    QuestionBusiness questionBusiness;

    // -- getQuestions test -- //
    @Test
    void getQuestionsTest(){
        assertTrue(questionBusiness.getQuestions().size() > 0);
    }

    // -- getQuestionById tests -- //
    @Test
    void getQuestionByIdIsPresentTest(){
        assertTrue(questionBusiness.getQuestionById(1L).isPresent());
    }

    @Test
    void getQuestionByIdIsSuccessTest(){
        assertTrue(questionBusiness.getQuestionById(1L).get().getQuestionState().equals("TACHI WAZA"));
    }

    @Test
    void getQuestionByIdIsFailureTest(){
        assertTrue(questionBusiness.getQuestionById(0L).isEmpty());
    }

    // -- getRandomQuestion tests -- //
    @RepeatedTest(100)
    void randomQuestionIdValueMoreZeroTest(){
        assertTrue(questionBusiness.getRandomQuestion().get().getQuestionID() > 0);
    }

    @RepeatedTest(100)
    void randomQuestionIdValueless4Test(){
        assertTrue(questionBusiness.getRandomQuestion().get().getQuestionID() < 5);
    }

    @RepeatedTest(100)
    void randomQuestionIdValueNotNullIdTest(){
        assertNotNull(questionBusiness.getRandomQuestion().get().getQuestionID());
    }

}
