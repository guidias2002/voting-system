package com.gcd.voting_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgendaPostDto {

    private String agenda;

    public String getAgenda() {
        return agenda;
    }
}
