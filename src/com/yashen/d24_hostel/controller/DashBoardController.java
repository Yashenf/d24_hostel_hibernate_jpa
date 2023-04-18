package com.yashen.d24_hostel.controller;

import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.session_storage.SignedUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable{

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userNameLbl.setText(SignedUser.username);
        setDate();
        setTime();

    }
    private void setTime() {
        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
                    timeLbl.setText(LocalDateTime.now().format(formatter));

                }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void setDate() {
        dateLbl.setText(new SimpleDateFormat("yyyy:MM:dd").format(new Date()));
    }
}
