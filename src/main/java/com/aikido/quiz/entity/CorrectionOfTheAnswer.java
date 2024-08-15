package com.aikido.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "correction_of_the_answers")
public class CorrectionOfTheAnswer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correction_of_the_answer_id")
    private long correctionOfTheAnswerId;

    @Column(name = "message_for_a_good_answer")
    private String messageForAGoodAnswer;

    @Column(name = "message_for_wrong_answer")
    private String messageForWrongAnswer;

    @JsonIgnore
    @OneToOne(mappedBy = "correctionOfTheAnswer")
    private QuestionMO question;

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

    public QuestionMO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionMO question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "CorrectionOfTheAnswer{" +
                "correctionOfTheAnswerId=" + correctionOfTheAnswerId +
                ", messageForAGoodAnswer='" + messageForAGoodAnswer + '\'' +
                ", messageForWrongAnswer='" + messageForWrongAnswer + '\'' +
                '}';
    }
}