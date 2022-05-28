module com.animalia.crudanimalia {
    requires javafx.controls;
    requires javafx.fxml;
    requires c3p0;
    requires java.sql;
    requires java.naming;


    opens com.animalia.crudanimalia to javafx.fxml;
    exports com.animalia.crudanimalia;
    exports com.animalia.crudanimalia.model;
    opens com.animalia.crudanimalia.model to javafx.fxml;
}