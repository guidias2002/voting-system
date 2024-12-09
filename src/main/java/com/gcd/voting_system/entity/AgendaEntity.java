package com.gcd.voting_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String agenda;
    private LocalDateTime createdAt;

}

