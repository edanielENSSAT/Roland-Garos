package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Entrainement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrainementRepo extends JpaRepository<Entrainement, Long> {

    //query methods
    void deleteEntrainementById(Long id);

    Optional<Entrainement> findEntrainementById(Long id);
}