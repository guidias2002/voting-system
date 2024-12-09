package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.dto.VotingPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VotingService {

    VotingDto createVoting(Long agendaId);

    void vote(Long votingId, Boolean voting);

    List<VotingDto> findAllVoting();
}
