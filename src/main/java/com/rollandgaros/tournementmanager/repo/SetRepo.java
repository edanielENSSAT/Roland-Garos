package com.rollandgaros.tournementmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rollandgaros.tournementmanager.model.Set;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SetRepo extends JpaRepository<Set, Long> {
    //query
    void deleteSetById(Long id);

    Optional<Set> findSetById(Long id);

    Optional<ArrayList<Set>> findAllSetByMatchId(Long id);
}
