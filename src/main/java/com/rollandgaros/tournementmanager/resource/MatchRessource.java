package com.rollandgaros.tournementmanager.resource;


import com.rollandgaros.tournementmanager.model.TennisMatch;
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
    public ResponseEntity<List<TennisMatch>> getAllMatch(){
        List<TennisMatch> matches = matchService.findAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TennisMatch> getMatchById(@PathVariable("id") Long id){
        TennisMatch match = matchService.findMatchById(id);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TennisMatch> addMatch(@RequestBody TennisMatch match) {
        TennisMatch newMatch = matchService.addMatch(match);
        return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TennisMatch> updateMatch(@RequestBody TennisMatch match) {
        TennisMatch updateMatch = matchService.updateMatch(match);
        return new ResponseEntity<>(updateMatch, HttpStatus.OK);
    }

    @GetMapping("findMatchesByPlayer/{id}")
    public ResponseEntity<List<TennisMatch>> getMatchesByPlayer(@PathVariable("id") Long id){
        List<TennisMatch> matches = matchService.findMatchByPlayer(id);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
