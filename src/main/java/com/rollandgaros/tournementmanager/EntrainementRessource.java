
package com.rollandgaros.tournementmanager;


import com.rollandgaros.tournementmanager.model.Entrainement;
import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.service.EntrainementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/entrainement")
public class EntrainementRessource  {
    private final EntrainementService entrainementService;

    public EntrainementRessource(EntrainementService entrainementService){this.entrainementService =entrainementService;}

    @GetMapping("/all")
   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity<List<Entrainement>> getAllEntrainement(){
        List<Entrainement> entrainements = entrainementService.findAllEntrainements();
        return new ResponseEntity<>(entrainements, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PLAYER','ROLE_MATCH')")
    public ResponseEntity< Entrainement> getEntrainementById(@PathVariable("id") Long id){
        Entrainement entrainement = entrainementService.findEntrainementsById(id);
        return new ResponseEntity<>( entrainement, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('match:write')")
    public ResponseEntity<Entrainement> addEntrainement(@RequestBody Entrainement entrainement) {
        Entrainement newentrainement = entrainementService.addEntrainement(entrainement);
        return new ResponseEntity<>(newentrainement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('match:write')")
    public ResponseEntity<Entrainement> updateEntrainement(@RequestBody Entrainement entrainement) {
        Entrainement updateEntrainement = entrainementService.updateEntrainement(entrainement);
        return new ResponseEntity<>(updateEntrainement, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteEntrainement(@PathVariable("id") Long id) {
        entrainementService.deleteEntrainement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


