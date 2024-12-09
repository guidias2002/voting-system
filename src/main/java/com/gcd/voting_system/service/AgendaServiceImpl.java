package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.AgendaDto;
import com.gcd.voting_system.dto.AgendaPostDto;
import com.gcd.voting_system.entity.AgendaEntity;
import com.gcd.voting_system.mapper.AgendaMapper;
import com.gcd.voting_system.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private AgendaMapper agendaMapper;

    @Override
    public void createAgenda(AgendaPostDto agendaPostDto) {
        AgendaEntity agendaEntity = AgendaEntity.builder()
                .agenda(agendaPostDto.getAgenda())
                .createdAt(LocalDateTime.now())
                .build();

        agendaRepository.save(agendaEntity);
    }

    @Override
    public List<AgendaDto> findAllAgenda() {

        return agendaMapper.toAgendaDtoList(agendaRepository.findAll());
    }
}
