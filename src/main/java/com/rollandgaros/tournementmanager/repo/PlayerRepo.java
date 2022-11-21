package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

    //query methods
    void deletePlayerById(Long id);

    Optional<Player> findPlayerById(Long id);
}
