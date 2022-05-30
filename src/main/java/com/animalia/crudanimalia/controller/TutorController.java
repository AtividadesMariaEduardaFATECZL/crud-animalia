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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TutorController {
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty cpf = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>();

    private final TableView<Tutor> table = new TableView<>();

    Connection connection = new ConnectionFactory().retrieveConnection();
    private final TutorDao dao = new TutorDao(connection);

    private final ObservableList<Tutor> tutors = FXCollections.observableArrayList();

    public TutorController() throws SQLException {
        TableColumn<Tutor, String> col1 = new TableColumn<>("Nome");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Tutor, String> col2 = new TableColumn<>("CPF");
        col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        TableColumn<Tutor, String> col3 = new TableColumn<>("Aniversário");
        col3.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        col3.setCellValueFactory((itemData)-> {
            LocalDate dt = itemData.getValue().getBirthday();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new ReadOnlyStringWrapper(dt.format(formatter));
        });

        table.getColumns().addAll(col1, col2, col3);

        table.setItems(tutors);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty cpfProperty() {
        return cpf;
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public TableView getTable() {
        return table;
    }

    public void add() throws SQLException {
        Tutor tutor = new Tutor(name.get(),cpf.get(), birthday.get());
        tutors.add(tutor);
        dao.insert(tutor);
    }

}
