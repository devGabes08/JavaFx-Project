package App;
import Arquivos.ArquivoProduto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ExcluirProduto {
    public Scene getScene() {
        TextField txtNome = new TextField(); txtNome.setPromptText("Nome do produto a excluir");
        Button btnExcluir = new Button("Excluir");
        Button btnVoltar = new Button("Voltar");

        btnExcluir.setOnAction(e -> {
            new ArquivoProduto().excluir(txtNome.getText());
            new Alert(Alert.AlertType.INFORMATION, "Excluído (se existia).").show();
            txtNome.clear();
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Excluir Produto"), txtNome, btnExcluir, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 200);
    }
}