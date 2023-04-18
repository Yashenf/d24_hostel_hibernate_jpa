package com.yashen.d24_hostel.controller.room;

import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.controller.student.UpdateStudentController;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.enums.RoomType;
import com.yashen.d24_hostel.util.converter.DtoToTm;
import com.yashen.d24_hostel.util.enums.Routes;
import com.yashen.d24_hostel.util.navigation.Navigation;
import com.yashen.d24_hostel.view.tm.RoomTypeTM;
import com.yashen.d24_hostel.view.tm.StudentTM;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class RoomsMainFormController implements Initializable {

    DtoToTm dtoToTm = new DtoToTm();
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);

    @FXML
    private ComboBox<String> roomtypeCmb;

    @FXML
    private TextField searchRoomTxt;

    @FXML
    private TableView<RoomTypeTM> roomTbl;

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
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/room/NewRoomForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        NewRoomFormController controller = fxmlLoader.getController();
        controller.init(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void roomtypeCmbOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void searchRoomTxtOnAction(ActionEvent event) {

    }

    @FXML
    void updateRoomOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/yashen/d24_hostel/view/room/UpdateRoomForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent load = fxmlLoader.load();
        UpdateRoomFormController controller = fxmlLoader.getController();
        controller.init(roomTbl.getSelectionModel().getSelectedItem().getId(),this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noCol.setCellValueFactory(new PropertyValueFactory("no"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory("roomType"));
        keyMoneyCol.setCellValueFactory(new PropertyValueFactory("keyMoney"));
        roomQtyCol.setCellValueFactory(new PropertyValueFactory("qty"));
        optionsCol.setCellValueFactory(new PropertyValueFactory("option"));

        try {
            setData();
            loadCmb();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadCmb() throws IOException {
        List<RoomDto> allRooms = roomBo.findAllRooms();
        roomtypeCmb.getItems().clear();
        int no=0;
        for (RoomDto dto:allRooms){
            System.out.println(dto.getRoomType());
            roomtypeCmb.getItems().add(dto.getRoomType());
        }
    }

    public void setData() throws IOException {
        roomTbl.getItems().clear();
        ArrayList<RoomTypeTM> tmList= dtoToTm.convertToRoomDtoToRoomTm(roomBo.findAllRooms());
        if (tmList != null){
            ObservableList<RoomTypeTM> fxList = FXCollections.observableArrayList();
            fxList.clear();
            fxList.setAll(tmList);
            for (RoomTypeTM r: fxList){

                r.getOption().setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "are you sure whether do you want to delete this Room Type ?",
                            ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            if (roomBo.deleteRoom(roomBo.findSRoom(r.getId()))) {
                                new Alert(Alert.AlertType.INFORMATION, "Room Deleted!").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    try {
                        roomTbl.refresh();
                        setData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
            }
            roomTbl.getItems().setAll(fxList);
        }

    }
}
