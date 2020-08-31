package edu.nicolasnavarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nicolasnavarro.dao.UserDTO;
import edu.nicolasnavarro.dao.repositories.UserDtoRepository;
import edu.nicolasnavarro.models.User;
import edu.nicolasnavarro.responses.UserResponse;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "/api/usuario", tags = "Usuario Profile Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/usuario")
public class UserController {

	@Autowired
	private UserDtoRepository userRepository;

	@PostMapping(value = "login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody User user) {
		UserResponse u = null;
		try {

			List<UserDTO> lista = this.userRepository.findAll();
			for (UserDTO item : lista) {
				if (item.getCorreo().equals(user.getCorreo()) && item.getClave().equals(user.getClave())) {
					u = new UserResponse(item);
					u.setMessage("Ingreso Correcto " + item.getCorreo());
					u.setStatusCode(200);
				}
			}
			return ResponseEntity.ok(u);
		} catch (Exception e) {
			u = new UserResponse(null);
			u.setMessage("Acceso incorrecto: " + e.getMessage());
			u.setStatusCode(300);
			return ResponseEntity.ok(u);
		}

	}

	@GetMapping(value = "{id}")
	public ResponseEntity<UserResponse> getUsuario(@PathVariable int id) {
		UserResponse ru = null;
		try {
			ru = new UserResponse(userRepository.findById(id).get());
			ru.setMessage("Usuario Encontrado");
			ru.setStatusCode(200);
			return ResponseEntity.ok(ru);
		} catch (Exception e) {
			ru = new UserResponse(null);
			ru.setMessage(e.getMessage());
			ru.setStatusCode(300);
			return ResponseEntity.ok(ru);
		}
	}

}
