package com.aikido.quiz.repositoriy;

import com.aikido.quiz.entity.QuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionMO, Long> {
}
