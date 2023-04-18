package com.yashen.d24_hostel.controller.user;

import com.yashen.d24_hostel.bo.custom.UserBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewUserFormController {

    UserBo userBo = BoFactory.getBoFactory().getBo(BoTypes.USER);
    UserMainFormController userMainFormController;
    @FXML
    private AnchorPane context;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField mobileTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    void regesterBtnOnAction(ActionEvent event) throws IOException {
        UserDto userDto = new UserDto();

        userDto.setUserName(nameTxt.getText());
        userDto.setPassword(passwordTxt.getText());
        userDto.setMobileNumber(mobileTxt.getText());

        boolean b = userBo.saveUser(userDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"User Saved!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Saved!").show();
        }
        userMainFormController.loadData();
    }

    public void init(UserMainFormController userMainFormController) {
        this.userMainFormController= userMainFormController;
    }
}
