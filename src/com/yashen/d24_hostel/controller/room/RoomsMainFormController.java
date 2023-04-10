package com.yashen.d24_hostel.controller.room;

import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RoomsMainFormController {

    @FXML
    private ComboBox<?> roomtypeCmb;

    @FXML
    private TextField searchRoomTxt;

    @FXML
    private TableView<?> roomTbl;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> roomTypeCol;

    @FXML
    private TableColumn<?, ?> keyMoneyCol;

    @FXML
    private TableColumn<?, ?> roomQtyCol;

    @FXML
    private TableColumn<?, ?> avalableQtyCol;

    @FXML
    private TableColumn<?, ?> optionsCol;

    @FXML
    void addNewRoomOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.NEWROOM);
    }

    @FXML
    void roomtypeCmbOnAction(ActionEvent event) {

    }

    @FXML
    void searchRoomTxtOnAction(ActionEvent event) {

    }

    @FXML
    void updateRoomOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.UPDATEROOM);
    }

}
