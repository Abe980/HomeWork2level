module ru.gb.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    exports ru.gb.javafxapp.client;
    opens ru.gb.javafxapp.client to javafx.fxml;
}