package seguranca;

import domains.seguranca.Usuario;
import infra.models.repo.Repository;

import java.util.Optional;

public interface UsuarioRepository extends Repository<Usuario,Long> {


    /**
     * Retorna o nome do usuario.
     *
     * @param idUsuario Id do usuario.
     *
     * @return
     */
    Optional<String> buscaNome(Long idUsuario);
}
