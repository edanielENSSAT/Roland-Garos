package com.rollandgaros.tournementmanager.repo;

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

    @Query(value = "select * from player order by won_matches desc",
            nativeQuery = true)
    List<Player> findAllByWonMatchs();

    @Query(value = "select * from player order by play_time desc",
    nativeQuery = true)
    List<Player> findAllByPlayTime();
}
