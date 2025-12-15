module com.example.techstorage {
    requires javafx.controls;
    requires javafx.fxml;

    exports App;
    exports Cadastros;
    exports Arquivos;

    opens App to javafx.fxml;
}