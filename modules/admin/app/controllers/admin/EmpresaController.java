package controllers.admin;

import admin.EmpresaRepository;
import domains.admin.Empresa;
import infra.controllers.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static play.libs.Json.toJson;

public class EmpresaController extends Controller {

    private final EmpresaRepository empresaRepository;

    @Inject
    public EmpresaController(final EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Result buscarEmpresas() {
        return withTransaction(
            true,
            () -> {
                final List<Empresa> empresas = empresaRepository.findAll();
                return isNotEmpty(empresas) ? ok(toJson(empresas)) :  noContent();
            }
        );
    }
}
