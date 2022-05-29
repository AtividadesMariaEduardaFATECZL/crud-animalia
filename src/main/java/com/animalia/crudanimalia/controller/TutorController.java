package com.animalia.crudanimalia.controller;

import com.animalia.crudanimalia.ConnectionFactory;
import com.animalia.crudanimalia.model.*;
import com.animalia.crudanimalia.persistence.TutorDao;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class TutorController {
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty cpf = new SimpleStringProperty("");
    private final ObjectProperty<BigDecimal> remuneration = new SimpleObjectProperty<>();
    private final ObjectProperty<HomeKind> homeKind = new SimpleObjectProperty<>();

    Connection connection = new ConnectionFactory().retrieveConnection();
    private final TutorDao dao = new TutorDao(connection);

    private final ObservableList<Tutor> tutors = FXCollections.observableArrayList();

    public TutorController() throws SQLException {
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty cpfProperty() {
        return cpf;
    }

    public ObjectProperty<BigDecimal> remunerationProperty() {
        return remuneration;
    }

    public void add() throws SQLException {
        Tutor tutor = new Tutor(name.get(),cpf.get(), remuneration.get(), homeKind.get());
        tutors.add(tutor);
        dao.insert(tutor);
    }

}
