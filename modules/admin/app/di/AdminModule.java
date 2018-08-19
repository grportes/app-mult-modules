package di;

import com.google.inject.AbstractModule;
import services.admin.EmpresaService;
import services.admin.impl.EmpresaServiceImpl;

public class AdminModule extends AbstractModule {


    @Override
    protected void configure() {

        bind(EmpresaService.class).to(EmpresaServiceImpl.class);
    }
}
