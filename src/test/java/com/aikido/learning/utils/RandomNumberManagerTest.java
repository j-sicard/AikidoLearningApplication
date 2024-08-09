package com.aikido.learning.utils;

import com.aikido.quiz.AikidoQuizApplication;
import com.aikido.quiz.utils.RandomNumberManager;
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
public class RandomNumberManagerTest {
    @Autowired
    RandomNumberManager randomNumberManager;


    @RepeatedTest(100)
    void generateRandomIntNotNullTest(){
        assertNotNull(randomNumberManager.generateRandomInt());
    }

    @RepeatedTest(100)
    void generateRandomIntNotEqualZeroTest(){
        assertTrue(randomNumberManager.generateRandomInt() > 0);
    }

    @RepeatedTest(100)
    void generateRandomIntNotSuperiorAtFourTest(){
        assertTrue(randomNumberManager.generateRandomInt() < 5);
    }
}
