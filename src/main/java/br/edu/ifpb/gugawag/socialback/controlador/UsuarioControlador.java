package br.edu.ifpb.gugawag.socialback.controlador;

import br.edu.ifpb.gugawag.socialback.modelo.Usuario;
import br.edu.ifpb.gugawag.socialback.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return this.usuarioServico.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioPorId(@PathVariable("id") Long idUsuario) {
        return this.usuarioServico.getUsuarioPorId(idUsuario);
    }

    @PostMapping
    public Usuario inserir(@RequestBody Usuario novoUsuario) {
        return this.usuarioServico.inserirOuAtualizar(novoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return this.usuarioServico.inserirOuAtualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.usuarioServico.apagar(id);
    }

}
