package App;
import Arquivos.ArquivoArmazem;
import Cadastros.Armazem;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InserirArmazem {
    public Scene getScene() {
        TextField txtCod = new TextField(); txtCod.setPromptText("Código");
        TextField txtEnd = new TextField(); txtEnd.setPromptText("Endereço");
        Button btnSalvar = new Button("Salvar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoArmazem().salvar(new Armazem(txtCod.getText(), txtEnd.getText()));
                new Alert(Alert.AlertType.INFORMATION, "Salvo!").show();
                txtCod.clear(); txtEnd.clear();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Erro").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Novo Armazém"), txtCod, txtEnd, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}