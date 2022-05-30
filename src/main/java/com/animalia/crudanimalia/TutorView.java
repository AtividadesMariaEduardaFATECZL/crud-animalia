package com.animalia.crudanimalia;

import com.animalia.crudanimalia.controller.TutorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class TutorView extends Application {
    private final TextField txtName = new TextField();
    private final TextField txtCpf = new TextField();

    private final Button btnAdicionar = new Button("Adicionar");
    private final Button btnPesquisar = new Button("Pesquisar");
    private final TutorController control = new TutorController();

    public TutorView() throws Exception {
    }

    @Override
    public void start(Stage stage) {
        BorderPane principal = new BorderPane();
        GridPane grid = new GridPane();
        principal.setTop(grid);

        grid.add(new Label("Nome"), 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(new Label("CPF"), 0, 1);
        grid.add(txtCpf, 1, 1);

        grid.add(btnPesquisar, 6, 5);
        grid.add(btnAdicionar, 7, 5);

        principal.setCenter(control.getTable());

        Bindings.bindBidirectional(control.nameProperty(), txtName.textProperty());
        Bindings.bindBidirectional(control.cpfProperty(), txtCpf.textProperty());

        btnPesquisar.setOnAction(e -> {
            try {
                control.pesquisar();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnAdicionar.setOnAction( e -> {
            try {
                control.add();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene scn = new Scene(principal, 500, 500);
        stage.setScene(scn);
        stage.setTitle("Cadastro tutor");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
