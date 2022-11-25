package com.rollandgaros.tournementmanager.resource;

import com.rollandgaros.tournementmanager.model.TennisSet;
import com.rollandgaros.tournementmanager.service.SetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequestMapping("/set")
public class SetRessource {
    private final SetService setService;

    public SetRessource(SetService setService){this.setService=setService;}

    @GetMapping("/find/{id}")
    public ResponseEntity<List<TennisSet>> getAllSetByMatch(@PathVariable("id")Long id){
        List<TennisSet> sets = setService.findAllSetByMatch(id);
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TennisSet>> getAllSet(){
        List<TennisSet> sets = setService.findAllSet();
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Integer> getNbMatchs(@PathVariable("id")Long id){
        int nbsets = setService.getNbSet(id);
        return new ResponseEntity<>(nbsets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TennisSet> getSetById(@PathVariable("id")Long id){
        TennisSet set = setService.findSetById(id);
        return new ResponseEntity<>(set, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<TennisSet> addSet(@RequestBody TennisSet set) {
        TennisSet newSet = setService.addSet(set);
        return new ResponseEntity<>(newSet, CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TennisSet> updateMatch(@RequestBody TennisSet set) {
        TennisSet updateSet = setService.updateSet(set);
        return new ResponseEntity<>(updateSet, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteSet(@PathVariable("id") Long id) {
        setService.deleteSet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
