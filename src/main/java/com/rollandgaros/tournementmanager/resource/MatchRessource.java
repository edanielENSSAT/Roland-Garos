package com.rollandgaros.tournementmanager.resource;


import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchRessource {
    private final MatchService matchService;

    public MatchRessource(MatchService matchService){this.matchService =matchService;}

    @GetMapping("/all")
    public ResponseEntity<List<Match>> getAllMatch(){
        List<Match> matches = matchService.findAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id){
        Match match = matchService.findMatchById(id);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        Match newMatch = matchService.addMatch(match);
        return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
        Match updateMatch = matchService.updateMatch(match);
        return new ResponseEntity<>(updateMatch, HttpStatus.OK);
    }

    @GetMapping("findMatchesByPlayer/{id}")
    public ResponseEntity<List<Match>> getMatchesByPlayer(@PathVariable("id") Long id){
        List<Match> matches = matchService.findMatchByPlayer(id);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
