package com.yashen.d24_hostel.controller.room;

import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.util.enums.RoomTypes;
import com.yashen.d24_hostel.view.tm.RoomTypeTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateRoomFormController {

    public TextField roomTypeTxt;
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);
    RoomDto room;
    RoomsMainFormController roomsMainFormController;
    @FXML
    private TextField keyMoneyTxt;

    @FXML
    private TextField qtyTxt;


    @FXML
    void updateRoomBtnOnAction(ActionEvent event) throws IOException {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setRoomType(roomTypeTxt.getText().trim());
        roomDto.setQty(Integer.parseInt(qtyTxt.getText()));
        roomDto.setKeyMoney(Double.parseDouble(keyMoneyTxt.getText()));
        boolean b = roomBo.updateSRoom(roomDto);

        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Room Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Updated!").show();
        }
        roomsMainFormController.setData();

    }

    public void init(int id, RoomsMainFormController controller) throws IOException {
        this.room = roomBo.findSRoom(id);
        this.roomsMainFormController = controller;
        System.out.println("inited");
        roomTypeTxt.setText(room.getRoomType());
        keyMoneyTxt.setText(String.valueOf(room.getKeyMoney()));
        qtyTxt.setText(String.valueOf(room.getQty()));
    }

}