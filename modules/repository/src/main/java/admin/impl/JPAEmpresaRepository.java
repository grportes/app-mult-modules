package admin.impl;

import admin.EmpresaRepository;
import domains.admin.Empresa;
import infra.models.repo.impl.JPARepository;

public class JPAEmpresaRepository extends JPARepository<Empresa,Long>
                                    implements EmpresaRepository {

}
