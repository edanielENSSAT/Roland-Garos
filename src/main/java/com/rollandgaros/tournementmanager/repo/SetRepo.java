package com.rollandgaros.tournementmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rollandgaros.tournementmanager.model.TennisSet;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SetRepo extends JpaRepository<TennisSet, Long> {
    //query
    void deleteSetById(Long id);

    TennisSet findSetById(Long id);

    Optional<ArrayList<TennisSet>> findAllSetByMatchId(Long id);

    @Query(value = "select count('matchId') from tennis_set where 'matchId' = id ",
            nativeQuery = true)
    int getNbSets(@Param("id") Long id);
}
