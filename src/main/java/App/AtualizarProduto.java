package App;
import Arquivos.ArquivoProduto;
import Cadastros.Produto;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AtualizarProduto {
    public Scene getScene() {
        TextField txtBusca = new TextField(); txtBusca.setPromptText("Nome do produto para editar");
        TextField txtPreco = new TextField(); txtPreco.setPromptText("Novo Preço");
        TextField txtQtd = new TextField(); txtQtd.setPromptText("Nova Quantidade");
        Button btnSalvar = new Button("Atualizar");
        Button btnVoltar = new Button("Voltar");

        btnSalvar.setOnAction(e -> {
            try {
                new ArquivoProduto().salvar(new Produto(txtBusca.getText(), Double.parseDouble(txtPreco.getText()), Integer.parseInt(txtQtd.getText())));
                new Alert(Alert.AlertType.INFORMATION, "Atualizado!").show();
            } catch(Exception ex) { new Alert(Alert.AlertType.ERROR, "Erro. Verifique o nome.").show(); }
        });
        btnVoltar.setOnAction(e -> MainApp.palco.setScene(MainApp.cenaMenu));

        VBox layout = new VBox(10, new Label("Atualizar Produto"), txtBusca, txtPreco, txtQtd, btnSalvar, btnVoltar);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        return new Scene(layout, 300, 300);
    }
}