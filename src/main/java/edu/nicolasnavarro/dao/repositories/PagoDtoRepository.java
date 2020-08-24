package edu.nicolasnavarro.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.nicolasnavarro.dao.PagoDTO;

@Repository
public interface PagoDtoRepository extends JpaRepository<PagoDTO, Integer>{
	
}
