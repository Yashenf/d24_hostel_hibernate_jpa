package com.yashen.d24_hostel.controller.user;

import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserMainFormController {

    @FXML
    private AnchorPane context;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<?> userTbl;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> mobileCol;

    @FXML
    private TableColumn<?, ?> jobCol;

    @FXML
    private TableColumn<?, ?> optionCol;

    @FXML
    void newUserBtnOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.NEWUSER);
    }

    @FXML
    void updateUserOnAction(ActionEvent event) throws IOException {
        Navigation.openWindow(Routes.UPDATEUSER);
    }

}
