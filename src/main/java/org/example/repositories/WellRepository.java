package org.example.repositories;

import org.example.entities.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WellRepository extends JpaRepository<Well, Integer> {
}
