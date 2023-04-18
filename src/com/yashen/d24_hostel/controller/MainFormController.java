package com.yashen.d24_hostel.controller;

import com.yashen.d24_hostel.bo.custom.UserBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.UserDto;
import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.session_storage.SignedUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {

    UserBo userBo = BoFactory.getBoFactory().getBo(BoTypes.USER);

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
//        Navigation.navigate(Routes.DASHBOARD,container);
        UserDto user = userBo.findSUser(usernameTxt.getText());
        if (user != null){
            System.out.println("texted password is :"+passwordTxt.getText()+", real password is : "+user.getPassword()+" , "+user.getUserName().equals(passwordTxt.getText()));
            if (user.getPassword().equals(passwordTxt.getText().trim())){
                SignedUser.username=usernameTxt.getText().trim();
                Navigation.navigate(Routes.DASHBOARD,container);
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Check password and try again").show();
            }
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Check username and try again").show();
        }
    }

    @FXML
    void usernameTxtOnAction(ActionEvent event) {

    }

}
