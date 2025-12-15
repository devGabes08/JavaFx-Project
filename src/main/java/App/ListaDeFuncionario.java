package App;
import Arquivos.ArquivoFuncionario;
import Cadastros.Funcionario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ListaDeFuncionario {
    public Scene getScene() {
        ListView<Funcionario> lista = new ListView<>();
        lista.getItems().addAll(new ArquivoFuncionario().ler());
        Button btnVoltar = new Button("Voltar");
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Lista de Funcionários"), lista, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 400, 400);
    }
}