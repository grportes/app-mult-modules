package domains.admin;

import infra.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Objects;

@Entity
@Table(name = "empresas")
public class Empresa extends Model {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // COLUNAS MAPEADAS
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // GETTERS/SETTERS
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // EQUALS & HASCODE
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(getId(), empresa.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
