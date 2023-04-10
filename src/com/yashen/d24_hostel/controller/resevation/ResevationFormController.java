package com.yashen.d24_hostel.controller.resevation;

import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ResevationFormController {

    @FXML
    private AnchorPane context;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<?> resevationTbl;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> studentCol;

    @FXML
    private TableColumn<?, ?> roomCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> optionCol;

    @FXML
    void makeNewResevationOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.NEWRESEVATION);
    }

    @FXML
    void searchTxtOnAction(KeyEvent event) {

    }

    @FXML
    void updateResevationOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.UPDATERESEVATION);
    }

}
