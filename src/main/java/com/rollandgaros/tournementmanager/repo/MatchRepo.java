package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<Match, Long>{

    //query methods
    void deleteMatchById(Long id);

    Optional<Match> findMatchById(Long id);


    @Query(value = "select * from tennis_match where player1 = id or  player2 = id",
            nativeQuery = true)
    Optional<List<Match>> findMatchByPlayer(Long id);

}
