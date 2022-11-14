package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MatchRepo extends JpaRepository<Match, Long>{

    //query methods
    void deleteMatchById(Long id);

    Optional<Match> findMatchById(Long id);
}
