package com.aikido.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class QuestionMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long questionID;

    @Column(name = "question_states")
    private String questionState;

    @Column(name = "correct_answers")
    private String correctAnswer;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "question_response",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "response_id")
    )
    private Set<ResponseMO> responses = new HashSet<>();


    public QuestionMO(long questionID, String questionState, String correctAnswer, Set<ResponseMO> responses) {
        this.questionID = questionID;
        this.questionState = questionState;
        this.correctAnswer = correctAnswer;
        this.responses = responses;
    }

    public QuestionMO() {
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionState() {
        return questionState;
    }

    public void setQuestionState(String questionState) {
        this.questionState = questionState;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Set<ResponseMO> getResponses() {
        return responses;
    }

    public void setResponses(Set<ResponseMO> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "QuestionMO{" +
                "questionID=" + questionID +
                ", questionState='" + questionState + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", responses=" + responses +
                '}';
    }
}
