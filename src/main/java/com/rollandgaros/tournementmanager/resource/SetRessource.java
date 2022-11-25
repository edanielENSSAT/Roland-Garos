package com.rollandgaros.tournementmanager.resource;

import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.model.Set;
import com.rollandgaros.tournementmanager.service.SetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/set")
public class SetRessource {
    private final SetService setService;

    public SetRessource(SetService setService){this.setService=setService;}

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity<List<Set>> getAllSetByMatch(@PathVariable("id")Long id){
        List<Set> sets = setService.findAllSetByMatch(id);
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @GetMapping("/all")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')") Pas nécessaire : accessible visiteurs
    public ResponseEntity<List<Set>> getAllSet(){
        List<Set> sets = setService.findAllSet();
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('match:write')")
    public ResponseEntity<Set> addSet(@RequestBody Set set) {
        Set newset = setService.addSet(set);
        return new ResponseEntity<>(newset, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('match:write')")
    public ResponseEntity<Set> updateMatch(@RequestBody Set set) {
        Set updateSet = setService.updateSet(set);
        return new ResponseEntity<>(updateSet, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity<?> deleteSet(@PathVariable("id") Long id) {
        setService.deleteSet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
