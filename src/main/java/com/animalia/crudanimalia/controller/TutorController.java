package com.animalia.crudanimalia.controller;

import com.animalia.crudanimalia.ConnectionFactory;
import com.animalia.crudanimalia.model.*;
import com.animalia.crudanimalia.persistence.TutorDao;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TutorController {
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty cpf = new SimpleStringProperty("");

    private final TableView<Tutor> table = new TableView<>();

    Connection connection = new ConnectionFactory().retrieveConnection();
    private final TutorDao dao = new TutorDao(connection);

    private final ObservableList<Tutor> tutors = FXCollections.observableArrayList();

    public TutorController() throws SQLException {
        TableColumn<Tutor, String> col1 = new TableColumn<>("Nome");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Tutor, String> col2 = new TableColumn<>("CPF");
        col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        table.getColumns().addAll(col1, col2);

        table.setItems(tutors);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty cpfProperty() {
        return cpf;
    }

    public TableView getTable() {
        return table;
    }

    public void add() throws SQLException {
        Tutor tutor = new Tutor(name.get(),cpf.get());
        tutors.add(tutor);
        dao.insert(tutor);
        System.out.println("Tutores inseridos: " + dao.findAll().toString());
    }


    public void search() throws SQLException {
        List<Tutor> tutorsFound = dao.findByName(name.get());
        tutors.clear();
        tutors.addAll(tutorsFound);
    }

}
