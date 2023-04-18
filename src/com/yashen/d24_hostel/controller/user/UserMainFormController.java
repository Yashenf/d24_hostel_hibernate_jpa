package com.yashen.d24_hostel.controller.user;

import com.yashen.d24_hostel.bo.custom.UserBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.controller.room.NewRoomFormController;
import com.yashen.d24_hostel.controller.room.UpdateRoomFormController;
import com.yashen.d24_hostel.dto.UserDto;
import com.yashen.d24_hostel.util.converter.DtoToTm;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.view.tm.UserTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserMainFormController implements Initializable {

    UserBo userBo = BoFactory.getBoFactory().getBo(BoTypes.USER);
    DtoToTm dtoToTm= new DtoToTm();

    @FXML
    private AnchorPane context;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<UserTM> userTbl;

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
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/user/NewUserForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        NewUserFormController controller = fxmlLoader.getController();
        controller.init(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void updateUserOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/user/updateUserForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        UpdateUserFormController controller = fxmlLoader.getController();
        controller.init(userTbl.getSelectionModel().getSelectedItem().getName(),this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noCol.setCellValueFactory(new PropertyValueFactory<>("no"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        jobCol.setCellValueFactory(new PropertyValueFactory<>("job"));
        optionCol.setCellValueFactory(new PropertyValueFactory<>("option"));
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() throws IOException {
        List<UserDto> allUsers = userBo.findAllUsers();
        ArrayList<UserTM> userTMS = dtoToTm.convertToUserDtoToTm(allUsers);
        for (UserTM userTM: userTMS){
            userTM.getOption().setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "are you sure whether do you want to delete this User ?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    try {
                        if (userBo.deleteUser(userBo.findSUser(userTM.getName()))) {
                            new Alert(Alert.AlertType.INFORMATION, "User Deleted!").show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                        }
                        loadData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                userTbl.refresh();

            });
            userTbl.getItems().clear();
            ObservableList<UserTM> obList = FXCollections.observableArrayList();
            obList.addAll(userTMS);
            userTbl.getItems().setAll(obList);
        }
    }
}
