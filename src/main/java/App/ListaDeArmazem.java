package App;
import Arquivos.ArquivoArmazem;
import Cadastros.Armazem;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ListaDeArmazem {
    public Scene getScene() {
        ListView<Armazem> lista = new ListView<>();
        lista.getItems().addAll(new ArquivoArmazem().ler());
        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Lista de Armazéns"), lista, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 400, 400);
    }
}