package edu.nicolasnavarro.dtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.nicolasnavarro.dtos.AlumnoDTO;

@Repository
public interface AlumnoDtoRepository extends JpaRepository<AlumnoDTO, Integer>{

}
