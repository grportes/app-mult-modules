package services.admin;

import domains.admin.Empresa;

import java.util.Optional;

public interface EmpresaService {

    Optional<Empresa> dadosEmpresa();
}
