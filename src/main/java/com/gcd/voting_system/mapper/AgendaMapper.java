package com.gcd.voting_system.mapper;

import com.gcd.voting_system.dto.AgendaDto;
import com.gcd.voting_system.entity.AgendaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaMapper {

    List<AgendaDto> toAgendaDtoList(List<AgendaEntity> agendaEntityList);
}
