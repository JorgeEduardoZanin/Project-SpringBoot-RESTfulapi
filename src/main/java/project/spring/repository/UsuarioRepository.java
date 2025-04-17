package project.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.spring.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findAllByOrderByNomeAsc();
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.nome LIKE %?1% ORDER BY u.nome")
	public List<Usuario> findAllWhereNomeOrderByNome(String nome);
	
}
