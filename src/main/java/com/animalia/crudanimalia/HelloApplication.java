package com.animalia.crudanimalia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private final TextField txtNome = new TextField();
    private final TextField monthlyCost = new TextField();
    private final TextField size = new TextField();
    private final TextField kind = new TextField();

    private final Button btnAdicionar = new Button("Adicionar");
    private final Button btnPesquisar = new Button("Pesquisar");
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane principal = new BorderPane();
        GridPane grid = new GridPane();
        principal.setTop(grid);

        grid.add(new Label("Nome"), 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(new Label("Custo mensal"), 0, 1);
        grid.add(monthlyCost, 1, 1);
        grid.add(new Label("Tipo"), 0, 2);
        grid.add(kind, 1, 2);
        grid.add(new Label("Tamanho"), 0, 3);
        grid.add(size, 1, 3);

        grid.add(btnPesquisar, 6, 5);
        grid.add(btnAdicionar, 7, 5);

        Scene scn = new Scene(principal, 500, 500);
        stage.setScene(scn);
        stage.setTitle("Adoção de animais");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}