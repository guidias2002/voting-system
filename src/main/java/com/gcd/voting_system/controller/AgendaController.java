package com.gcd.voting_system.controller;

import com.gcd.voting_system.dto.AgendaDto;
import com.gcd.voting_system.dto.AgendaPostDto;
import com.gcd.voting_system.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/create")
    public ResponseEntity<Void> createAgenda(@RequestBody AgendaPostDto agendaPostDto) {
        agendaService.createAgenda(agendaPostDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AgendaDto>> findAllAgenda() {

        return ResponseEntity.ok(agendaService.findAllAgenda());
    }
}
