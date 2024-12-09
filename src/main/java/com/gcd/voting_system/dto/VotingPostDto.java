package com.gcd.voting_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VotingPostDto {

    private Long id;
    private Long agendaId;
    private String agenda;
    private Boolean vote;
    private int upvotes;
    private int negativeVotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
