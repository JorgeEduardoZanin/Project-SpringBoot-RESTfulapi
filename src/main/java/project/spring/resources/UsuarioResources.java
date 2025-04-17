package project.spring.resources;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.spring.entities.Usuario;
import project.spring.services.UsuarioServices;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResources {

	@Autowired
	private UsuarioServices services;
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO GET 
	 *
	 *
	 */
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> listaUsuarios = services.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
	}
	
	@GetMapping(value = "/id/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario = services.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@GetMapping(value = "/nome/{nome}")
	@ResponseBody
	public ResponseEntity<List<Usuario>> findAllLikeName(@PathVariable String nome){
		List<Usuario> userList = services.findAllByLikeName(nome);
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO POST
	 *
	 *
	 */
	@PostMapping
	@ResponseBody
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
		usuario = services.saveUser(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO PUT
	 *
	 *
	 */
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario, @PathVariable Long id){
		usuario = services.updateUser(usuario, id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO DELETE
	 *
	 *
	 */
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(services.deleteUserById(id));
	}
}
