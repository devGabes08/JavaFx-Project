package Arquivos;
import Cadastros.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoProduto {
    private final String arquivo = "produtos.dat";

    public void salvar(Produto p) {
        List<Produto> lista = ler();
        lista.removeIf(x -> x.getNome().equalsIgnoreCase(p.getNome())); // Substitui se já existir
        lista.add(p);
        gravar(lista);
    }
    public void excluir(String nome) {
        List<Produto> lista = ler();
        if (lista.removeIf(x -> x.getNome().equalsIgnoreCase(nome))) gravar(lista);
    }
    public List<Produto> ler() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Produto>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
    private void gravar(List<Produto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) { e.printStackTrace(); }
    }
}