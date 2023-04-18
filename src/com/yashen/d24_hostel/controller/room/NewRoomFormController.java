package com.yashen.d24_hostel.controller.room;

import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.enums.RoomType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewRoomFormController {

    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);
    RoomsMainFormController controller;

    @FXML
    private TextField keyMoneyTxt;

    @FXML
    private TextField qtyTxt;

    @FXML
    private TextField roomTypeTxt;

    @FXML
    void addNewRoomBtnOnAction(ActionEvent event) throws IOException {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomType(roomTypeTxt.getText());
        roomDto.setKeyMoney(Double.parseDouble(keyMoneyTxt.getText()));
        roomDto.setQty(Integer.parseInt(qtyTxt.getText()));
        boolean b = roomBo.saveRoom(roomDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Room Saved!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Saved!").show();
        }
        controller.setData();
    }

    public void init(RoomsMainFormController controller){
        this.controller= controller;
    }

}
