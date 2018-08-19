package vendas.impl;

import domains.vendas.Cliente;
import vendas.ClienteRepository;

import java.util.Optional;

public class JPAClienteRepository implements ClienteRepository {

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {

        Cliente c = new Cliente();
        c.setId(1L);;
        c.setRazaoSocial("ZE DAS COUVES");

        return Optional.of(c);
    }
}
