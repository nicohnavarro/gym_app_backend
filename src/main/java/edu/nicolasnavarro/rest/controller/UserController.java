package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.UserDTO;
import edu.nicolasnavarro.dao.repositories.UserDtoRepository;
import edu.nicolasnavarro.models.User;
import edu.nicolasnavarro.responses.UserResponse;

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
				u.setClave(item.getClave());
			}
		}
		return ResponseEntity.ok(u);
	}
	
	@GetMapping(value="usuario/{id}")
	public ResponseEntity<UserResponse> getUsuario(@PathVariable int id){
		UserResponse ru = null;
		try {
				ru = new UserResponse(userRepository.findById(id).get());
				ru.setMessage("Usuario Encontrado");
				ru.setStatusCode(200);
				return ResponseEntity.ok(ru);			
		}catch(Exception e) {
			ru = new UserResponse(null);
			ru.setMessage(e.getMessage());
			ru.setStatusCode(300);
			return ResponseEntity.ok(ru);
		}
	}
	
}
