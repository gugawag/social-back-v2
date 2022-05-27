package br.edu.ifpb.gugawag.socialback.servico;

import br.edu.ifpb.gugawag.socialback.modelo.Usuario;
import br.edu.ifpb.gugawag.socialback.repositorio.UsuarioRepositorioIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Usuario inserirOuAtualizar(Usuario usuario) {
        if (usuario.getIdade() < 18) {
            throw new RuntimeException("menor de idade");
        }
        Usuario usuarioInserido = this.usuarioRepositorio.save(usuario);
        return usuarioInserido;
    }

}
