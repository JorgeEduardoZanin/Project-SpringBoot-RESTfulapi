package project.spring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.entities.Usuario;
import project.spring.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	/*
	 *
	 * 
	 SERVICES TIPO GET
	 *
	 *
	 */
	public List<Usuario> findAll(){
		return repository.findAllByOrderByNomeAsc();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}
	
	public List<Usuario> findAllByLikeName(String name){
		return repository.findAllWhereNomeOrderByNome(name);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO POST
	 *
	 *
	 */
	public Usuario saveUser(Usuario usuario) {
		return usuario = repository.save(usuario);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO PUT
	 *
	 *
	 */
	public Usuario updateUser(Usuario usuario, Long id) {
		usuario.setId(id);
		return usuario = repository.saveAndFlush(usuario);
	}
	/*
	 *
	 * 
	 SERVICES DO TIPO DELETE
	 *
	 *
	 */
	public String deleteUserById(Long id) {
		repository.deleteById(id);
		return "Usuario deletado com sucesso!";
	}
	
	

}
