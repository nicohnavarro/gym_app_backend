package edu.nicolasnavarro.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nicolasnavarro.dao.UserDTO;

@Repository
public interface UserDtoRepository extends JpaRepository<UserDTO, Integer>{

}
