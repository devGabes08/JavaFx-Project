package App;
import Arquivos.ArquivoFuncionario;
import Cadastros.Funcionario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InserirFuncionario {
    public Scene getScene() {
        TextField txtNome = new TextField(); txtNome.setPromptText("Nome");
        TextField txtCpf = new TextField(); txtCpf.setPromptText("CPF");
        TextField txtCargo = new TextField(); txtCargo.setPromptText("Cargo");
        Button btnSalvar = new Button("Salvar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoFuncionario().salvar(new Funcionario(txtNome.getText(), txtCpf.getText(), txtCargo.getText()));
                new Alert(Alert.AlertType.INFORMATION, "Funcionário Salvo!").show();
                txtNome.clear(); txtCpf.clear(); txtCargo.clear();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Erro nos dados").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Novo Funcionário"), txtNome, txtCpf, txtCargo, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}