package com.yashen.d24_hostel.controller;

import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.util.enums.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController {

    @FXML
    private AnchorPane container;

    @FXML
    private Label userNameLbl;

    @FXML
    private Label jobLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private AnchorPane containerPane;


    @FXML
    void backToMainForm(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MAINFORM,container);
    }

    @FXML
    void roomsManagementBtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ROOMMAIN,containerPane);
    }

    @FXML
    void studentManagementBtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STUDENTMAIN,containerPane);
    }

    @FXML
    void usersManagemetBtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.USERMAIN,containerPane);
    }

    public void resevationsManagementBtnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RESEVATIONMAIN,containerPane);
    }


    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage window = (Stage) containerPane.getScene().getWindow();
        containerPane.getChildren().add(FXMLLoader.load(getClass().getResource("/com/yashen/d24_hostel/view/student/StudentForm.fxml")));
    }*/
}
