package domains.transporte;

import infra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Veiculo extends Model {

    @Id
    private Long id;

    @Column
    private Long nroFrota;

    @Column
    private String descricao;

    @Column
    private Long version;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // GETTERS & SETTERS
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // EQUALS & HASHCODE
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
