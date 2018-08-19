package transporte;

import java.util.Optional;

public interface VeiculoRepository {

    Optional<Long> buscarNroFrota( final Long idVeiculo );
}
