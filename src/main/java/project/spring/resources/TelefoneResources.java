package project.spring.resources;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import project.spring.entities.Telefone;
import project.spring.services.TelefoneServices;

@RestController
@RequestMapping(value = "/usuario/{usuarioId}/telefone")
public class TelefoneResources {

	@Autowired
	private TelefoneServices services;
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO GET 
	 *
	 *
	 */
	@GetMapping
	public ResponseEntity<List<Telefone>> findAll(@PathVariable Long usuarioId){
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll(usuarioId));
	}
	
	@GetMapping(value = "/{idTel}")
	public ResponseEntity<Telefone> findById(@PathVariable Long idTel,  @PathVariable Long usuarioId){
		return ResponseEntity.status(HttpStatus.OK).body(services.findById(idTel, usuarioId));
		
	}
	
	@GetMapping(value = "/numero/{numero}")
	public ResponseEntity<List<Telefone>> findAllByNumero(@PathVariable String numero, @PathVariable Long usuarioId){
		return ResponseEntity.status(HttpStatus.OK).body(services.findByNumero(numero, usuarioId));
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO POST
	 *
	 *
	 */
	@PostMapping
	public ResponseEntity<Telefone> save(@PathVariable Long usuarioId, @RequestBody Telefone telefone){
		return ResponseEntity.status(HttpStatus.CREATED).body(services.saveTelefone(telefone, usuarioId));
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO PUT
	 *
	 *
	 */
	@PutMapping(value = "/{idTel}")
	public ResponseEntity<Telefone> updateTelefone(@PathVariable Long usuarioId, @PathVariable Long idTel, @RequestBody Telefone telefone) {
		return ResponseEntity.status(HttpStatus.OK).body(services.updateTelefone(telefone, idTel, usuarioId));
	}
	/*
	 *
	 * 
	 CONTROLADORES DO TIPO DELETE
	 *
	 *
	 */
	@DeleteMapping(value = "/{idTel}")
	public ResponseEntity<String> deletaTelefone(@PathVariable Long idTel){
		return ResponseEntity.status(HttpStatus.OK).body(services.deleteTelefoneById(idTel));
	}
}

