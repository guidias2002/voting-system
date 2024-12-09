package com.gcd.voting_system.service;

import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.entity.AgendaEntity;
import com.gcd.voting_system.entity.VotingEntity;
import com.gcd.voting_system.exception.customExceptions.ExpiredVoteException;
import com.gcd.voting_system.exception.customExceptions.NotFoundException;
import com.gcd.voting_system.mapper.VotingMapper;
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

    @Autowired
    private VotingMapper votingMapper;

    @Override
    public VotingDto createVoting(Long agendaId) {
        AgendaEntity agendaEntity = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new NotFoundException("Pauta não encotrada."));

        LocalDateTime expirationTime = LocalDateTime.now().plusSeconds(60);

        VotingEntity votingEntity = VotingEntity.builder()
                .agendaId(agendaEntity.getId())
                .agenda(agendaEntity.getAgenda())
                .upvotes(0)
                .negativeVotes(0)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .status(true)
                .expirationTime(expirationTime)
                .build();

        votingRepository.save(votingEntity);

        return votingMapper.toVotingDto(votingEntity);
    }

    @Override
    public void vote(Long votingId, Boolean voting) {
        VotingEntity votingEntity = votingRepository.findById(votingId)
                .orElseThrow(() -> new NotFoundException("Votação não encontrada."));

        if(!votingEntity.getStatus()) {
            throw new ExpiredVoteException("Votação expirada.");
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

        return votingMapper.toVotingDtoList(votingRepository.findAll());
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
