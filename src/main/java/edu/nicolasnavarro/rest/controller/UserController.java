package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.UserDTO;
import edu.nicolasnavarro.dao.repositories.UserDtoRepository;
import edu.nicolasnavarro.models.User;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserDtoRepository userRepository;
	
	@PostMapping(value="authenticationUser")
	public ResponseEntity<User> authUser(@RequestBody User user){
		User u = null;
		List<UserDTO>lista = this.userRepository.findAll();
		for(UserDTO item : lista) {
			if(item.getUsuario().equals(user.getUsuario()) && item.getClave().equals(user.getClave()))
			{
				u = new User();
				u.setUsuario(item.getUsuario());
			}
		}
		return ResponseEntity.ok(u);
	}
	
}
