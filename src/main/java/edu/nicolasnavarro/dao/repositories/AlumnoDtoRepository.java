package edu.nicolasnavarro.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nicolasnavarro.dao.AlumnoDTO;

@Repository
public interface AlumnoDtoRepository extends JpaRepository<AlumnoDTO, Integer>{

}
