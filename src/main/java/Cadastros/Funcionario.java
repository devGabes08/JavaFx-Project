package Cadastros;
import java.io.Serializable;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        this.nome = nome; this.cpf = cpf; this.cargo = cargo;
    }
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    @Override public String toString() { return "CPF: " + cpf + " | " + nome + " (" + cargo + ")"; }
}