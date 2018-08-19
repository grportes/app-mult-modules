package vendas;

import domains.vendas.Cliente;

import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> buscarClientePorId(final Long id );
}
