package com.gcd.voting_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AgendaDto {

    private Long id;
    private String agenda;
    private LocalDateTime createdAt;

}
