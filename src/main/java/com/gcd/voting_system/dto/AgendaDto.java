package com.gcd.voting_system.dto;

import java.time.LocalDateTime;

public class AgendaDto {

    private Long id;
    private String agenda;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getAgenda() {
        return agenda;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AgendaDto(Long id, String agenda, LocalDateTime createdAt) {
        this.id = id;
        this.agenda = agenda;
        this.createdAt = createdAt;
    }
}
