package com.reinforcement.project.dataAccess.abstracts;

import com.reinforcement.project.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
