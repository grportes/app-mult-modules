package seguranca.impl;

import domains.seguranca.Usuario;
import infra.models.repo.impl.JPARepository;
import seguranca.UsuarioRepository;

import javax.persistence.NoResultException;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;


public class JPAUsuarioRepositoryImpl extends JPARepository<Usuario,Long>
                                        implements UsuarioRepository {

    @Override
    public Optional<String> buscaNome( final Long idUsuario ) {

        requireNonNull( idUsuario, "Obrigatório informar [ idUsuario ]" );

        try {
            return ofNullable(
                getEm().createNamedQuery( "Usuario.buscarNomePorId", String.class )
                    .setParameter( "idUsuario", idUsuario )
                    .getSingleResult()
            );
        } catch (NoResultException e) {
            return empty();
        }


    }


}
