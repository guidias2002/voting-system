package com.gcd.voting_system.mapper;

import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.entity.VotingEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VotingMapper {

    VotingDto toVotingDto(VotingEntity votingEntity);

    List<VotingDto> toVotingDtoList(List<VotingEntity> votingEntityList);
}
