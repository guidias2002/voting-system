package com.gcd.voting_system.dto;

import jakarta.validation.constraints.NotNull;


public record VoteDto (
        @NotNull(message = "O voto deve ser true ou false.")
        Boolean vote
) {}
