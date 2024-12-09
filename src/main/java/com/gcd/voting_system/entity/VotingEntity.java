package com.gcd.voting_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "voting")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long agendaId;
    private String agenda;
    private int upvotes;
    private int negativeVotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;
    private LocalDateTime expirationTime;

}
