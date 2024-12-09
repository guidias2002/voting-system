package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.entity.AgendaEntity;
import com.gcd.voting_system.entity.VotingEntity;
import com.gcd.voting_system.repository.AgendaRepository;
import com.gcd.voting_system.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotingServiceImpl implements VotingService{

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public VotingDto createVoting(Long agendaId) {
        AgendaEntity agendaEntity = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new RuntimeException("Agenda not found."));

        LocalDateTime expirationTime = LocalDateTime.now().plusSeconds(60);

        VotingEntity votingEntity = new VotingEntity(agendaEntity.getId(), agendaEntity.getAgenda(), 0, 0, LocalDateTime.now(), LocalDateTime.now(), true, expirationTime);
        votingRepository.save(votingEntity);

        VotingDto votingDto = new VotingDto(votingEntity.getId(), votingEntity.getAgenda(), votingEntity.getAgendaId(), votingEntity.getUpvotes(), votingEntity.getNegativeVotes(), votingEntity.getCreatedAt(), votingEntity.getUpdatedAt(), votingEntity.getStatus());

        return votingDto;
    }

    @Override
    public void vote(Long votingId, Boolean voting) {
        VotingEntity votingEntity = votingRepository.findById(votingId)
                .orElseThrow(() -> new RuntimeException("Voting not found."));

        if(!votingEntity.getStatus()) {
            throw new RuntimeException("Votação expirada.");
        }

        if(voting) {
            votingEntity.setUpvotes(votingEntity.getUpvotes() +1);
        } else {
            votingEntity.setNegativeVotes(votingEntity.getNegativeVotes() +1);
        }

        votingEntity.setUpdatedAt(LocalDateTime.now());

        votingRepository.save(votingEntity);

    }

    @Override
    public List<VotingDto> findAllVoting() {

        return votingRepository.findAll().stream().map(
                v -> new VotingDto(v.getId(), v.getAgenda(), v.getAgendaId(), v.getUpvotes(), v.getNegativeVotes(), v.getCreatedAt(), v.getUpdatedAt(), v.getStatus())
        ).toList();
    }

    @Scheduled(fixedRate = 10000)
    private void updateExpiredVotes() {
        List<VotingEntity> expiredVotes = votingRepository.findAllByExpirationTimeBeforeAndStatus(LocalDateTime.now(), true);
        expiredVotes.forEach(vote -> {
            vote.setStatus(false);
            vote.setUpdatedAt(LocalDateTime.now());
        });
        votingRepository.saveAll(expiredVotes);
    }
}
