package constantes;

public enum TipoPessoa {

    FISICA( "FISICA", (short) 1 ),

    JURIDICA( "JURIDICA", (short) 2 )

    ;

    private String descricao;
    private Short value;

    TipoPessoa(
        final String descricao,
        final Short value
    ) {

        this.descricao = descricao;
        this.value = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public Short getValue() {
        return value;
    }
}
