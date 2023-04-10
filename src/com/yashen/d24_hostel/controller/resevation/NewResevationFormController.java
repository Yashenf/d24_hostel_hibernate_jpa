package com.yashen.d24_hostel.controller.resevation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewResevationFormController {

    @FXML
    private AnchorPane context;

    @FXML
    private TextField nicTxt;

    @FXML
    private ComboBox<?> roomTYpeCmb;

    @FXML
    private DatePicker datePkr;

    @FXML
    private TextField statusTxt;

    @FXML
    void makeResevationBtnOnAction(ActionEvent event) {

    }

}
