package Arquivos;
import Cadastros.Armazem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoArmazem {
    private final String arquivo = "armazens.dat";

    public void salvar(Armazem a) {
        List<Armazem> lista = ler();
        lista.removeIf(x -> x.getCodigo().equals(a.getCodigo()));
        lista.add(a);
        gravar(lista);
    }
    public void excluir(String codigo) {
        List<Armazem> lista = ler();
        if (lista.removeIf(x -> x.getCodigo().equals(codigo))) gravar(lista);
    }
    public List<Armazem> ler() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Armazem>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
    private void gravar(List<Armazem> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) { e.printStackTrace(); }
    }
}