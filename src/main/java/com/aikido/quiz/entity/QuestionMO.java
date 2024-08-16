package com.aikido.quiz.entity;

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

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "question_response",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "response_id")
    )
    private Set<ResponseMO> responses = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correction_of_the_answer_id", referencedColumnName = "correction_of_the_answer_id")
    private CorrectionOfTheAnswerMO correctionOfTheAnswer;


    public QuestionMO(long questionID, String questionState, Set<ResponseMO> responses, CorrectionOfTheAnswerMO correctionOfTheAnswer) {
        this.questionID = questionID;
        this.questionState = questionState;
        this.responses = responses;
        this.correctionOfTheAnswer = correctionOfTheAnswer;
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

    public Set<ResponseMO> getResponses() {
        return responses;
    }

    public void setResponses(Set<ResponseMO> responses) {
        this.responses = responses;
    }

    public CorrectionOfTheAnswerMO getCorrectionOfTheAnswer() {
        return correctionOfTheAnswer;
    }

    public void setCorrectionOfTheAnswer(CorrectionOfTheAnswerMO correctionOfTheAnswer) {
        this.correctionOfTheAnswer = correctionOfTheAnswer;
    }

    @Override
    public String toString() {
        return "QuestionMO{" +
                "questionID=" + questionID +
                ", questionState='" + questionState + '\'' +
                ", responses=" + responses +
                ", correctionOfTheAnswer=" + correctionOfTheAnswer +
                '}';
    }
}