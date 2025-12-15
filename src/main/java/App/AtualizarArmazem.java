package App;
import Arquivos.ArquivoArmazem;
import Cadastros.Armazem;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AtualizarArmazem {
    public Scene getScene() {
        TextField txtCod = new TextField(); txtCod.setPromptText("Código para editar");
        TextField txtEnd = new TextField(); txtEnd.setPromptText("Novo Endereço");
        Button btnSalvar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoArmazem().salvar(new Armazem(txtCod.getText(), txtEnd.getText()));
                new Alert(Alert.AlertType.INFORMATION, "Atualizado!").show();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Erro").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Atualizar Armazém"), txtCod, txtEnd, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}