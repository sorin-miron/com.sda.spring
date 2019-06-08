package com.sda.patientportal.model;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient sender;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor receiver;

//    private LocalDate sentDate;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Patient getSender() {
        return sender;
    }

    public void setSender(Patient sender) {
        this.sender = sender;
    }

    public Doctor getReceiver() {
        return receiver;
    }

    public void setReceiver(Doctor receiver) {
        this.receiver = receiver;
    }
}
