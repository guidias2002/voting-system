package com.gcd.voting_system.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "voting")
public class VotingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long agendaId;
    private String agenda;
    private Boolean vote;
    private int upvotes;
    private int negativeVotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;
    private LocalDateTime expirationTime;

    public VotingEntity(Long agendaId, String agenda, int upvotes, int negativeVotes, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean status, LocalDateTime expirationTime) {
        this.agendaId = agendaId;
        this.agenda = agenda;
        this.upvotes = upvotes;
        this.negativeVotes = negativeVotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.expirationTime = expirationTime;
    }

    public VotingEntity() {
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public Long getAgendaId() {
        return agendaId;
    }

    public String getAgenda() {
        return agenda;
    }

    public Boolean getVote() {
        return vote;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
