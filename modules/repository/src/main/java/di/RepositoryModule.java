package di;

import admin.EmpresaRepository;
import admin.impl.JPAEmpresaRepository;
import com.google.inject.AbstractModule;
import seguranca.UsuarioRepository;
import seguranca.impl.JPAUsuarioRepositoryImpl;

public class RepositoryModule extends AbstractModule {

    @Override
    protected void configure() {

        //
        // Admin
        //
        bind(EmpresaRepository.class).to(JPAEmpresaRepository.class);

        //
        // Segurança.
        //
        bind(UsuarioRepository.class).to(JPAUsuarioRepositoryImpl.class);
    }
}
