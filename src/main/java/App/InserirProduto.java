package App;
import Arquivos.ArquivoProduto;
import Cadastros.Produto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InserirProduto {
    public Scene getScene() {
        TextField txtNome = new TextField(); txtNome.setPromptText("Nome do Produto");
        TextField txtPreco = new TextField(); txtPreco.setPromptText("Preço");
        TextField txtQtd = new TextField(); txtQtd.setPromptText("Quantidade");
        Button btnSalvar = new Button("Salvar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoProduto().salvar(new Produto(txtNome.getText(), Double.parseDouble(txtPreco.getText()), Integer.parseInt(txtQtd.getText())));
                new Alert(Alert.AlertType.INFORMATION, "Produto Salvo!").show();
                txtNome.clear(); txtPreco.clear(); txtQtd.clear();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Dados inválidos!").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Novo Produto"), txtNome, txtPreco, txtQtd, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}