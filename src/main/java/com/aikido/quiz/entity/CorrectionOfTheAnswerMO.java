package com.aikido.quiz.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "correction_of_the_answers")
public class CorrectionOfTheAnswerMO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correction_of_the_answer_id")
    private long correctionOfTheAnswerId;

    @Column(name = "message_for_a_good_answer")
    private String messageForAGoodAnswer;

    @Column(name = "message_for_wrong_answer")
    private String messageForWrongAnswer;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "correction_response",
            joinColumns = @JoinColumn(name = "correction_of_the_answer_id"),
            inverseJoinColumns = @JoinColumn(name = "response_id")
    )
    private Set<ResponseMO> responses = new HashSet<>();

    public CorrectionOfTheAnswerMO(long correctionOfTheAnswerId, String messageForAGoodAnswer, String messageForWrongAnswer, Set<ResponseMO> responses) {
        this.correctionOfTheAnswerId = correctionOfTheAnswerId;
        this.messageForAGoodAnswer = messageForAGoodAnswer;
        this.messageForWrongAnswer = messageForWrongAnswer;
        this.responses = responses;
    }

    public CorrectionOfTheAnswerMO() {
    }

    public long getCorrectionOfTheAnswerId() {
        return correctionOfTheAnswerId;
    }

    public void setCorrectionOfTheAnswerId(long correctionOfTheAnswerId) {
        this.correctionOfTheAnswerId = correctionOfTheAnswerId;
    }

    public String getMessageForAGoodAnswer() {
        return messageForAGoodAnswer;
    }

    public void setMessageForAGoodAnswer(String messageForAGoodAnswer) {
        this.messageForAGoodAnswer = messageForAGoodAnswer;
    }

    public String getMessageForWrongAnswer() {
        return messageForWrongAnswer;
    }

    public void setMessageForWrongAnswer(String messageForWrongAnswer) {
        this.messageForWrongAnswer = messageForWrongAnswer;
    }

    public Set<ResponseMO> getResponses() {
        return responses;
    }

    public void setResponses(Set<ResponseMO> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "CorrectionOfTheAnswerMO{" +
                "correctionOfTheAnswerId=" + correctionOfTheAnswerId +
                ", messageForAGoodAnswer='" + messageForAGoodAnswer + '\'' +
                ", messageForWrongAnswer='" + messageForWrongAnswer + '\'' +
                ", responses=" + responses +
                '}';
    }
}