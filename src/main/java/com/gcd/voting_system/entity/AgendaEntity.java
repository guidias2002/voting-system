package com.gcd.voting_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String agenda;
    private LocalDateTime createdAt;

    public AgendaEntity(String agenda, LocalDateTime createdAt) {
        this.agenda = agenda;
        this.createdAt = LocalDateTime.now();
    }

    public AgendaEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getAgenda() {
        return agenda;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

