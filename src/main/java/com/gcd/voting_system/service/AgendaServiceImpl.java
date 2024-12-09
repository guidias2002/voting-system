package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.AgendaDto;
import com.gcd.voting_system.dto.AgendaPostDto;
import com.gcd.voting_system.entity.AgendaEntity;
import com.gcd.voting_system.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public void createAgenda(AgendaPostDto agendaPostDto) {
        AgendaEntity agenda = new AgendaEntity(agendaPostDto.getAgenda(), LocalDateTime.now());

        agendaRepository.save(agenda);
    }

    @Override
    public List<AgendaDto> findAllAgenda() {

        return agendaRepository.findAll().stream().map(
                a -> new AgendaDto(a.getId(), a.getAgenda(), a.getCreatedAt())
        ).toList();
    }
}
