package App;
import Arquivos.ArquivoFuncionario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ExcluirFuncionario {
    public Scene getScene() {
        TextField txtCpf = new TextField(); txtCpf.setPromptText("CPF a excluir");
        Button btnExcluir = new Button("Excluir");
        Button btnVoltar = new Button("Voltar");

        btnExcluir.setOnAction(e -> {
            new ArquivoFuncionario().excluir(txtCpf.getText());
            new Alert(Alert.AlertType.INFORMATION, "Excluído.").show();
            txtCpf.clear();
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Excluir Funcionário"), txtCpf, btnExcluir, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 200);
    }
}