package seguranca.impl;

import domains.seguranca.Usuario;
import infra.models.repo.impl.JPARepository;
import seguranca.UsuarioRepository;


public class JPAUsuarioRepositoryImpl extends JPARepository<Usuario,Long>
                                        implements UsuarioRepository {


}
