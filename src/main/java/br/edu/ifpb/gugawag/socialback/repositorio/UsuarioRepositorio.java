package br.edu.ifpb.gugawag.socialback.repositorio;

import br.edu.ifpb.gugawag.socialback.modelo.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsuarioRepositorio {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> getUsuarios(){
        return this.entityManager.createQuery("SELECT u " +
                "FROM Usuario u").getResultList();
    }

    public Usuario getUsuarioPorId(Long id){
        TypedQuery<Usuario> query = this.entityManager.createQuery("SELECT u " +
                "FROM Usuario u where u.id=:id", Usuario.class).
                setParameter("id", id);
        return query.getSingleResult();
    }


}
