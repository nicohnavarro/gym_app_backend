package edu.nicolasnavarro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nicolasnavarro.dtos.AlumnoDTO;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoDTO, Integer> {

}
