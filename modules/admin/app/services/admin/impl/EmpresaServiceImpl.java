package services.admin.impl;

import admin.EmpresaRepository;
import domains.admin.Empresa;
import services.admin.EmpresaService;

import javax.inject.Inject;
import java.util.Optional;

public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Inject
    public EmpresaServiceImpl( final EmpresaRepository empresaRepository ) {

        this.empresaRepository = empresaRepository;
    }

    @Override
    public Optional<Empresa> dadosEmpresa() {

        return empresaRepository.buscarEmpresa();
    }
}
