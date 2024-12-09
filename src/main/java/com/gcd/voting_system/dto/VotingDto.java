package com.gcd.voting_system.dto;

import java.time.LocalDateTime;

public class VotingDto {

    private Long id;
    private Long agendaId;
    private String agenda;
    private int upvotes;
    private int negativeVotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;

    public VotingDto(Long id, String agenda, Long agendaId, int upvotes, int negativeVotes, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean status) {
        this.id = id;
        this.agenda = agenda;
        this.agendaId = agendaId;
        this.upvotes = upvotes;
        this.negativeVotes = negativeVotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
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
}
