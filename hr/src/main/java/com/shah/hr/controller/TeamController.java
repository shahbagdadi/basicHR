package com.shah.hr.controller;

import com.shah.hr.exception.ResourceNotFoundException;
import com.shah.hr.model.Team;
import com.shah.hr.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/hr")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @PostMapping("/team")
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }


}
