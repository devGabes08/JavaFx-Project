package App;
import Arquivos.ArquivoArmazem;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ExcluirArmazem {
    public Scene getScene() {
        TextField txtCod = new TextField(); txtCod.setPromptText("Código a excluir");
        Button btnExcluir = new Button("Excluir");
        Button btnVoltar = new Button("Voltar");

        btnExcluir.setOnAction(e -> {
            new ArquivoArmazem().excluir(txtCod.getText());
            new Alert(Alert.AlertType.INFORMATION, "Excluído.").show();
            txtCod.clear();
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Excluir Armazém"), txtCod, btnExcluir, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 200);
    }
}