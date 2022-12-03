module ru.meowmure.javacreditest {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    opens ru.meowmure.javacreditest to javafx.fxml;
    exports ru.meowmure.javacreditest;
    exports ru.meowmure.javacreditest.Controllers;
    opens ru.meowmure.javacreditest.Controllers to javafx.fxml;
}