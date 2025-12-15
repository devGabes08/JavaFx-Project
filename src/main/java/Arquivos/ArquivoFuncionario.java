package Arquivos;
import Cadastros.Funcionario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoFuncionario {
    private final String arquivo = "funcionarios.dat";

    public void salvar(Funcionario f) {
        List<Funcionario> lista = ler();
        lista.removeIf(x -> x.getCpf().equals(f.getCpf()));
        lista.add(f);
        gravar(lista);
    }
    public void excluir(String cpf) {
        List<Funcionario> lista = ler();
        if (lista.removeIf(x -> x.getCpf().equals(cpf))) gravar(lista);
    }
    public List<Funcionario> ler() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Funcionario>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
    private void gravar(List<Funcionario> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) { e.printStackTrace(); }
    }
}