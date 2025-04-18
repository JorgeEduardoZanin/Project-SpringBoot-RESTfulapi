package project.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.entities.Telefone;
import project.spring.entities.Usuario;
import project.spring.repository.TelefoneRepository;

@Service
public class TelefoneServices {

	@Autowired
	private TelefoneRepository repository;
	/*
	 *
	 * 
	 SERVICES DO TIPO GET
	 *
	 *
	 */
	public List<Telefone> findAll(Long usuarioId){
		return repository.findByUsuarioIdOrderByNumeroAsc(usuarioId);
	}
	
	public Telefone findById(Long id, Long usuarioId) {
		return repository.findByIdAndUsuarioId(id, usuarioId);
	}
	
	public List<Telefone> findByNumero(String numero, Long usuarioId) {
		return repository.findAllByNumero(numero, usuarioId);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO POST
	 *
	 *
	 */
	public Telefone saveTelefone(Telefone telefone, Long usuarioId) {
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		telefone.setUsuario(usuario);
		return repository.save(telefone);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO PUT
	 *
	 *
	 */
	public Telefone updateTelefone(Telefone telefone, Long id, Long usuarioId) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		telefone.setId(id);
		telefone.setUsuario(usuario);
		return repository.saveAndFlush(telefone);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO DELETE
	 *
	 *
	 */
	public String deleteTelefoneById(Long id) {
		repository.deleteById(id);
		return "Telefone deletado com sucesso!";
	}
	


	
}
