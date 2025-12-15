package Cadastros;
import java.io.Serializable;

public class Armazem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String endereco;

    public Armazem(String codigo, String endereco) {
        this.codigo = codigo; this.endereco = endereco;
    }
    public String getCodigo() { return codigo; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override public String toString() { return "Cód: " + codigo + " | End: " + endereco; }
}