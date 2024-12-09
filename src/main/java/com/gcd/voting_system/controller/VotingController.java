package com.gcd.voting_system.controller;

import com.gcd.voting_system.dto.VotingDto;
import com.gcd.voting_system.service.VotingService;
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
    public ResponseEntity<Void> vote(@PathVariable Long votingId, @RequestBody Boolean voting) {
        votingService.vote(votingId, voting);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VotingDto>> findAllVoting() {

        return ResponseEntity.ok(votingService.findAllVoting());
    }
}