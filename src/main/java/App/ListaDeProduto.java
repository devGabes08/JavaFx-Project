package App;
import Arquivos.ArquivoProduto;
import Cadastros.Produto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ListaDeProduto {
    public Scene getScene() {
        ListView<Produto> lista = new ListView<>();
        lista.getItems().addAll(new ArquivoProduto().ler());
        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Lista de Produtos"), lista, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 400, 400);
    }
}