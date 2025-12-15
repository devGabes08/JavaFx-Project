package App;
import Arquivos.ArquivoFuncionario;
import Cadastros.Funcionario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AtualizarFuncionario {
    public Scene getScene() {
        TextField txtCpf = new TextField(); txtCpf.setPromptText("CPF do funcionário para editar");
        TextField txtNome = new TextField(); txtNome.setPromptText("Novo Nome");
        TextField txtCargo = new TextField(); txtCargo.setPromptText("Novo Cargo");
        Button btnSalvar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoFuncionario().salvar(new Funcionario(txtNome.getText(), txtCpf.getText(), txtCargo.getText()));
                new Alert(Alert.AlertType.INFORMATION, "Atualizado!").show();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Erro.").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Atualizar Funcionário"), txtCpf, txtNome, txtCargo, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}