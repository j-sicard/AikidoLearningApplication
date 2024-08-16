package com.aikido.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "response")
public class ResponseMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private long responseId;

    @Column(name = "response_states")
    private String responseStates;

    @JsonIgnore
    @ManyToMany(mappedBy = "responses")
    private Set<QuestionMO> questions = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "responses")
    private Set<CorrectionOfTheAnswerMO> correctionOfTheAnswers = new HashSet<>();

    public ResponseMO(long responseId, String responseStates, Set<QuestionMO> questions) {
        this.responseId = responseId;
        this.responseStates = responseStates;
        this.questions = questions;
    }

    public ResponseMO() {
    }

    // Getters and setters

    public long getResponseId() {
        return responseId;
    }

    public void setResponseId(long responseId) {
        this.responseId = responseId;
    }

    public String getResponseStates() {
        return responseStates;
    }

    public void setResponseStates(String responseStates) {
        this.responseStates = responseStates;
    }

    public Set<QuestionMO> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionMO> questions) {
        this.questions = questions;
    }



}
