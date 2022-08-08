module com.github.distriful5061.privatedairy.privatedairy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.github.distriful5061.privatedairy.privatedairy to javafx.fxml;
    exports com.github.distriful5061.privatedairy.privatedairy;
}