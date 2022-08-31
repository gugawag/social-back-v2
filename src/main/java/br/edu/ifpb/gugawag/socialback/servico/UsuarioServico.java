package br.edu.ifpb.gugawag.socialback.servico;

import br.edu.ifpb.gugawag.socialback.modelo.Usuario;
import br.edu.ifpb.gugawag.socialback.repositorio.UsuarioRepositorioIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorioIF usuarioRepositorio;

    public List<Usuario> getUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    public void apagar(Long id) {
        this.usuarioRepositorio.deleteById(id);
    }

    @Transactional
    @CacheEvict("maisidoso")
    public Usuario inserirOuAtualizar(Usuario usuario) {
        Usuario usuarioInserido = this.usuarioRepositorio.save(usuario);
        if (usuario.getIdade() < 18) {
            throw new MenorDeIdadeException();
        }

//        Usuario novo = new Usuario();
//        novo.setId(3L);
//        this.usuarioRepositorio.save(novo);
//
//        usuarioInserido.setNome(usuarioInserido.getNome() + "- Alterado");
        return usuarioInserido;
    }

    @Cacheable("maisidoso")
    public Usuario getUsuarioMaisIdoso() {
        return this.usuarioRepositorio.findTopByOrderByIdadeDesc();
    }
}
