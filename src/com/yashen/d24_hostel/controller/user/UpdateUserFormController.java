package com.yashen.d24_hostel.controller.user;

import com.yashen.d24_hostel.bo.custom.UserBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserFormController{

    UserMainFormController userMainFormController;
    UserBo userBo= BoFactory.getBoFactory().getBo(BoTypes.USER);
    UserDto selectedUser;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField mobileTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    void updateBtnOnAction(ActionEvent event) throws IOException {
        UserDto userDto = new UserDto();
        userDto.setUserName(userNameTxt.getText());
        userDto.setMobileNumber(mobileTxt.getText());
        userDto.setPassword(passwordTxt.getText());
        boolean b = userBo.updateUser(userDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"User Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Updated!").show();
        }
        userMainFormController.loadData();
    }

    public void init(String name, UserMainFormController userMainFormController) throws IOException {
        selectedUser = userBo.findSUser(name);
        this.userMainFormController= userMainFormController;
        userNameTxt.setText(selectedUser.getUserName());
        passwordTxt.setText(selectedUser.getPassword());
        mobileTxt.setText(selectedUser.getMobileNumber());
    }


}
