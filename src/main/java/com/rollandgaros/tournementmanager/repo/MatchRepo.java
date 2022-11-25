package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.TennisMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<TennisMatch, Long>{

    //query methods
    void deleteMatchById(Long id);

    Optional<TennisMatch> findMatchById(Long id);


    @Query(value = "select * from tennis_match where player1 = id or  player2 = id",
            nativeQuery = true)
    Optional<List<TennisMatch>> findMatchByPlayer(Long id);

}
