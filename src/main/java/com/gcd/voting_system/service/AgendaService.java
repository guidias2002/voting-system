package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.AgendaDto;
import com.gcd.voting_system.dto.AgendaPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendaService {

    void createAgenda(AgendaPostDto agendaPostDto);

    List<AgendaDto> findAllAgenda();

}
