package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Match;
import com.rollandgaros.tournementmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

    //query methods
    void deletePlayerById(Long id);

    Optional<Player> findPlayerById(Long id);

    @Query(value = "select * from player where gender = 'femme' order by won_matches desc",
            nativeQuery = true)
    List<Player> findAllByWonMatchsWomen();

    @Query(value = "select * from player where gender = 'homme' order by won_matches desc",
            nativeQuery = true)
    List<Player> findAllByWonMatchsMen();

    @Query(value = "select * from player where gender = 'homme' order by play_time desc",
    nativeQuery = true)
    List<Player> findAllByPlayTimeMen();

    @Query(value = "select * from player where gender = 'femme' order by play_time desc",
            nativeQuery = true)
    List<Player> findAllByPlayTimeWomen();

    @Query(value = "select * from player where gender = 'homme'order by id desc",
            nativeQuery = true)
    List<Player> findAllByMen();

    @Query(value = "select * from player where gender = 'femme'",
            nativeQuery = true)
    List<Player> findAllByWomen();

    @Query(value = "select * from player order by currentRank desc",
            nativeQuery = true)
    List<Player> findAllRank();

    @Query(value = "select * from player order by firstname desc",
            nativeQuery = true)
    List<Player> findAllName();


}
