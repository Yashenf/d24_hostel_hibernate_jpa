package com.yashen.d24_hostel.controller;

import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.util.enums.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {

    @FXML
    public AnchorPane container;
    @FXML
    private PasswordField passwordTxt;

    @FXML
    private ImageView showPasswordBtn;

    @FXML
    private TextField usernameTxt;

    @FXML
    void fogotPasswordOnAction(MouseEvent event) {

    }

    @FXML
    void passwordTxtOnAction(ActionEvent event) {

    }

    @FXML
    void showPasswordBtnOnAction(MouseEvent event) {

    }

    @FXML
    void signInBtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,container);
    }

    @FXML
    void usernameTxtOnAction(ActionEvent event) {

    }

}
