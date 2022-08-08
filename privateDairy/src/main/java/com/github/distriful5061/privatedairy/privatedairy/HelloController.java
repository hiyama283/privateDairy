package com.github.distriful5061.privatedairy.privatedairy;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class HelloController {
    private Password password;
    private FileManager fileManager;

    @FXML
    private DatePicker dairyDatePicker;

    @FXML
    public void onDatePicked() {
        System.out.println(dairyDatePicker.getValue().toString());
    }

    @FXML
    void initialize() {
        password = new Password();
        fileManager = new FileManager();
    }

    public LocalDate parseDate(String string) {
        int[] integers = new int[3];

        String[] strings = string.split("-");
        for (int i = 0; i < 3; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        return LocalDate.of(integers[0], integers[1], integers[2]);
    }
}