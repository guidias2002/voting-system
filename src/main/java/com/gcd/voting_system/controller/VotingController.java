package com.gcd.voting_system.controller;

import com.gcd.voting_system.dto.VoteDto;
import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.service.VotingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/createVoting/{agendaId}")
    public ResponseEntity<VotingDto> createVoting(@PathVariable Long agendaId) {

        return ResponseEntity.ok(votingService.createVoting(agendaId));
    }

    @PostMapping("/vote/{votingId}")
    public ResponseEntity<Void> vote(@PathVariable Long votingId, @Valid @RequestBody VoteDto voting) {
        votingService.vote(votingId, voting.vote());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VotingDto>> findAllVoting() {

        return ResponseEntity.ok(votingService.findAllVoting());
    }

    @GetMapping("/findAllVotingByAgendaId/{agendaId}")
    public ResponseEntity<List<VotingDto>> findAllVotingByAgendaId(@PathVariable Long agendaId) {

        return ResponseEntity.ok(votingService.findAllVotingByAgendaId(agendaId));
    }
}
