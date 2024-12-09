package com.gcd.voting_system.repository;

import com.gcd.voting_system.entity.VotingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VotingRepository extends JpaRepository<VotingEntity, Long> {
    List<VotingEntity> findAllByExpirationTimeBeforeAndStatus(LocalDateTime now, boolean status);

    List<VotingEntity> findAllVotingByAgendaId(Long agendaId);

}
