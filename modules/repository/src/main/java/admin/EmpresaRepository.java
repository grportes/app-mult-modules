package admin;

import domains.admin.Empresa;

import java.util.Optional;

public interface EmpresaRepository {

    Optional<Empresa> buscarEmpresa();
}
