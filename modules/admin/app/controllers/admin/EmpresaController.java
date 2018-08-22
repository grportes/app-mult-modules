package controllers.admin;

import admin.EmpresaRepository;
import domains.admin.Empresa;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static infra.UtilCollections.isVazia;
import static play.libs.Json.toJson;


public class EmpresaController extends Controller {

    private final EmpresaRepository empresaRepository;

    @Inject
    public EmpresaController(final EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    @Transactional(readOnly = true)
    public Result buscarEmpresas() {

        try {
            final List<Empresa> empresas = empresaRepository.findAll();
            if (isVazia(empresas))
                return noContent();
            return ok(toJson(empresas));
        } catch (Throwable e) {
            return badRequest(e.getMessage());
        }

    }
}
