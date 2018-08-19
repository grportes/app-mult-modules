package domains.transporte;

import java.util.Objects;

public class Veiculo {

    private Long id;
    private Long nroFrota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNroFrota() {
        return nroFrota;
    }

    public void setNroFrota(Long nroFrota) {
        this.nroFrota = nroFrota;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(getId(), veiculo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
