package controllers.admin;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import services.admin.EmpresaService;

import javax.inject.Inject;


public class EmpresaController extends Controller {

    private final EmpresaService empresaService;

    @Inject
    public EmpresaController( final EmpresaService empresaService ) {

        this.empresaService = empresaService;
    }


    public Result buscarEmpresa() {

        return empresaService.dadosEmpresa()
                .map( Json::toJson )
                .map( Results::ok )
                .orElse( noContent() );
    }
}
