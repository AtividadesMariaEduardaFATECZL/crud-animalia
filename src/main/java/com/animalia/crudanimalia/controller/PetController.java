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

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class PetController {
    private final StringProperty name = new SimpleStringProperty("");
    private final ObjectProperty<BigDecimal> monthlyCost = new SimpleObjectProperty<>();
    private final ObjectProperty<PetKind> kind = new SimpleObjectProperty<>();
    private final ObjectProperty<PetSize> size = new SimpleObjectProperty<>();

    Connection connection = new ConnectionFactory().retrieveConnection();
    private final PetDao dao = new PetDao(connection);

    private final TableView<Pet> table = new TableView<>();

    private final ObservableList<Pet> pets = FXCollections.observableArrayList();

    public PetController() throws SQLException {
        TableColumn<Pet, String> col1 = new TableColumn<>("Nome");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Pet, String> col2 = new TableColumn<>("Custo mensal");
        col2.setCellValueFactory(new PropertyValueFactory<>("monthlyCost"));
        TableColumn<Pet, String> col3 = new TableColumn<>("Tipo");
        col2.setCellValueFactory(new PropertyValueFactory<>("kind"));
        TableColumn<Pet, String> col4 = new TableColumn<>("Tamanho");
        col2.setCellValueFactory(new PropertyValueFactory<>("size"));

        table.getColumns().addAll(col1, col2, col3, col4);

        table.setItems(pets);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<PetKind> kindProperty() {
        return kind;
    }

    public ObjectProperty<PetSize> sizeProperty() {
        return size;
    }

    public ObjectProperty<BigDecimal> monthlyCostProperty() {
        return monthlyCost;
    }

    public void add() throws SQLException {
        Pet pet = new Pet(name.get(),monthlyCost.get(), kind.get(), size.get());
        pets.add(pet);
        dao.insert(pet);
    }

    public TableView getTable() {
        return table;
    }
}
