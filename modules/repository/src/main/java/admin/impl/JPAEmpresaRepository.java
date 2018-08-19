package admin.impl;

import admin.EmpresaRepository;
import domains.admin.Empresa;

import java.util.Optional;

public class JPAEmpresaRepository implements EmpresaRepository {

    @Override
    public Optional<Empresa> buscarEmpresa() {

        Empresa empresa = new Empresa();
        empresa.setId(10L);
        empresa.setRazaoSocial("EMPRESA MODELO S/A");

        return Optional.of(empresa);
    }
}
