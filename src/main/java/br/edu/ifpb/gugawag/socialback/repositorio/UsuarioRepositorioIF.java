package br.edu.ifpb.gugawag.socialback.repositorio;

import br.edu.ifpb.gugawag.socialback.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorioIF extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeAndIdade(String nome, Integer idade);

    @Query("SELECT u FROM Usuario u where (u.idade >= 60)")
    List<Usuario> getIdosos();

//    @Query("SELECT u FROM Usuario u where u.idade >= (SELECT max(idade) FROM Usuario)")
    Usuario findTopByOrderByIdadeDesc();
}
