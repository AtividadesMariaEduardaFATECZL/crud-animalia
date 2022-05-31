package com.animalia.crudanimalia.controller;

import com.animalia.crudanimalia.ConnectionFactory;
import com.animalia.crudanimalia.model.*;
import com.animalia.crudanimalia.persistence.PetDao;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PetController {
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty kind = new SimpleStringProperty("");
    private final StringProperty size = new SimpleStringProperty("");

    Connection connection = new ConnectionFactory().retrieveConnection();
    private final PetDao dao = new PetDao(connection);

    private final TableView<Pet> table = new TableView<>();

    private final ObservableList<Pet> pets = FXCollections.observableArrayList();

    public PetController() throws SQLException {
        TableColumn<Pet, String> col1 = new TableColumn<>("Nome");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Pet, String> col2 = new TableColumn<>("Tipo");
        col2.setCellValueFactory(new PropertyValueFactory<>("kind"));
        TableColumn<Pet, String> col3 = new TableColumn<>("Tamanho");
        col3.setCellValueFactory(new PropertyValueFactory<>("size"));

        table.getColumns().addAll(col1, col2, col3);

        table.setItems(pets);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty kindProperty() {
        return kind;
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void add() throws SQLException {
        Pet pet = new Pet(name.get(), kind.get(), size.get());
        pets.add(pet);
        dao.insert(pet);
        System.out.println(dao.findAll());
    }

    public TableView getTable() {
        return table;
    }
}
