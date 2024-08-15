package com.aikido.learning;

import com.aikido.quiz.AikidoQuizApplication;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = AikidoQuizApplication.class)
@TestPropertySource(locations="classpath:application-test.properties")
@Transactional
class AikidoQuizAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
