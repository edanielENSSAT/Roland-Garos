package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    //query
    void deleteTrainerById(Long id);

    Optional<Trainer> findTrainerById(Long id);
}
