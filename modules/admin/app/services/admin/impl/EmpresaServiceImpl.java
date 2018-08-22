package services.admin.impl;

import admin.EmpresaRepository;
import services.admin.EmpresaService;

import javax.inject.Inject;

public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Inject
    public EmpresaServiceImpl( final EmpresaRepository empresaRepository ) {

        this.empresaRepository = empresaRepository;
    }
}
