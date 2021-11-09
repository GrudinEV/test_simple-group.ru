package org.example.repositories;

import org.example.entities.WellParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WellParameterRepository extends JpaRepository<WellParameter, Integer> {
}
