package App;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static Stage palco;
    public static Scene cenaMenu;

    @Override
    public void start(Stage stage) {
        palco = stage;
        palco.setTitle("TechStorage - Sistema");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        layout.getChildren().addAll(
                new Label("--- PRODUTOS ---"),
                btn("Inserir Produto", () -> new InserirProduto().getScene()),
                btn("Atualizar Produto", () -> new AtualizarProduto().getScene()),
                btn("Excluir Produto", () -> new ExcluirProduto().getScene()),
                btn("Listar Produtos", () -> new ListaDeProduto().getScene()),
                new Separator(),
                new Label("--- FUNCIONÁRIOS ---"),
                btn("Inserir Funcionário", () -> new InserirFuncionario().getScene()),
                btn("Atualizar Funcionário", () -> new AtualizarFuncionario().getScene()),
                btn("Excluir Funcionário", () -> new ExcluirFuncionario().getScene()),
                btn("Listar Funcionários", () -> new ListaDeFuncionario().getScene()),
                new Separator(),
                new Label("--- ARMAZÉNS ---"),
                btn("Inserir Armazém", () -> new InserirArmazem().getScene()),
                btn("Atualizar Armazém", () -> new AtualizarArmazem().getScene()),
                btn("Excluir Armazém", () -> new ExcluirArmazem().getScene()),
                btn("Listar Armazéns", () -> new ListaDeArmazem().getScene())
        );

        cenaMenu = new Scene(layout, 550, 850);
        palco.setScene(cenaMenu);
        palco.show();
    }

    // Interface funcional para criar as cenas sob demanda (corrige erros de inicialização)
    interface SceneCreator { Scene create(); }

    private Button btn(String texto, SceneCreator creator) {
        Button b = new Button(texto);
        b.setMinWidth(200);
        b.setOnAction(e -> palco.setScene(creator.create()));
        return b;
    }

    public static void main(String[] args) { launch(); }
}