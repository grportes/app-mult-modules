package transporte.impl;

import transporte.VeiculoRepository;

import java.util.Optional;

public class JPAVeiculoRepository implements VeiculoRepository {


    @Override
    public Optional<Long> buscarNroFrota( final Long idVeiculo ) {

        return Optional.of( 100L );
    }
}
