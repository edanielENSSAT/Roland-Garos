package com.rollandgaros.tournementmanager;


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
        Match newmatch = matchService.addMatch(match);
        return new ResponseEntity<>(newmatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
        Match updateMatch = matchService.updateMatch(match);
        return new ResponseEntity<>(updateMatch, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
