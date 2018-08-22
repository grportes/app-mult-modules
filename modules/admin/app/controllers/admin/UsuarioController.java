package controllers.admin;

import domains.seguranca.Usuario;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import seguranca.UsuarioRepository;

import javax.inject.Inject;
import java.util.List;

import static infra.UtilCollections.isVazia;
import static play.libs.Json.toJson;

public class UsuarioController extends Controller {

    private final UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioController( final UsuarioRepository usuarioRepository ) {

        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public Result buscar(final Long idUsuario) {

        try {
            return usuarioRepository
                .findById(idUsuario)
                .map(Json::toJson)
                .map(Results::ok)
                .orElse(noContent());
        } catch (Throwable e) {
            return badRequest(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Result buscarTodos() {

        try {
            final List<Usuario> usuarios = usuarioRepository.findAll();
            if (isVazia(usuarios))
                return noContent();
            return ok(toJson(usuarios));
        } catch (Throwable e) {
            return badRequest(e.getMessage());
        }
    }

    @Transactional
    public Result criar() {

        try {
            Usuario usuario = new Usuario();
            usuario.setNome("ze comeia");
            usuarioRepository.save(usuario);
            return ok( toJson(usuario) );
        } catch (Throwable e) {
            return badRequest(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Result buscarNome( final Long idUsuario ) {

        try {
            return usuarioRepository
                    .buscaNome( idUsuario )
                    .map(Json::toJson)
                    .map(Results::ok)
                    .orElse(noContent());
        } catch (Throwable e) {
            return badRequest(e.getMessage());
        }
    }
}
