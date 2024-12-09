package com.gcd.voting_system.dto;

import java.time.LocalDateTime;

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
