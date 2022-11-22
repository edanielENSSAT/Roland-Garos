package com.rollandgaros.tournementmanager.repo;

import com.rollandgaros.tournementmanager.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Long> {

    //query methods
    void deleteTrainingById(Long id);

    Optional<Training> findTrainingById(Long id);
}
