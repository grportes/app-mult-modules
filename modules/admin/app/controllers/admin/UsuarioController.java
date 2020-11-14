package controllers.admin;

import domains.seguranca.Usuario;
import infra.controllers.Controller;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;
import seguranca.UsuarioRepository;

import javax.inject.Inject;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static play.libs.Json.toJson;

public class UsuarioController extends Controller {

    private final UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioController( final UsuarioRepository usuarioRepository ) {
        this.usuarioRepository = usuarioRepository;
    }

    public Result buscar(final Long idUsuario) {
        return withTransaction(
            true, () ->
            usuarioRepository.findById(idUsuario)
            .map(Json::toJson)
            .map(Results::ok)
            .orElse(noContent())
        );
    }

    public Result buscarTodos() {
        return withTransaction(true, () -> {
            final List<Usuario> usuarios = usuarioRepository.findAll();
            return isNotEmpty(usuarios) ? ok(toJson(usuarios)) : noContent();
        });
    }

    public Result criar() {
        return withTransaction(() -> {
            Usuario usuario = new Usuario();
            usuario.setNome("ze comeia");
            usuarioRepository.save(usuario);
            return ok( toJson(usuario) );
        });
    }

    public Result buscarNome( final Long idUsuario ) {
        return withTransaction(
            true,
            () -> usuarioRepository.buscaNome( idUsuario )
            .map(Json::toJson)
            .map(Results::ok)
            .orElse(noContent())
        );
    }
}
