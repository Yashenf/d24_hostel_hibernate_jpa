package com.yashen.d24_hostel.controller.resevation;

import com.yashen.d24_hostel.bo.custom.ReservationBo;
import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.util.converter.Converter;
import com.yashen.d24_hostel.view.tm.ResevationTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateResevationFormOnAction {

    ResevationFormController controller ;
    int selectedReservationId;
    ReservationDto resevation;
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);
    StudentBo studentBo=  BoFactory.getBoFactory().getBo(BoTypes.STUDENT);
    ReservationBo reservationBo= BoFactory.getBoFactory().getBo(BoTypes.RESERVATION);
    Converter converter= new Converter();


    @FXML
    private TextField nicTxt;

    @FXML
    private ComboBox<String> roomTYpeCmb;

    @FXML
    private DatePicker datePkr;

    @FXML
    private TextField statusTxt;

    @FXML
    void updateResevationBtnOnAction(ActionEvent event) throws IOException {
        boolean b = reservationBo.changeStatus(statusTxt.getText(), resevation.getId());
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Reservation Updated!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Updated!").show();
        }
        controller.setData();
    }

    public void init(ResevationFormController controller, int selectedReservationId) throws IOException {
        this.controller= controller;
        this.selectedReservationId= selectedReservationId;
        this.resevation= reservationBo.findSReservation(selectedReservationId);
        loadCmb();
        fillData();
    }



    private void fillData() {
        nicTxt.setText(resevation.getStudent().getNic());
        statusTxt.setText(resevation.getStatus());
        roomTYpeCmb.setValue(resevation.getRoom().getId()+"."+resevation.getRoom().getRoomType());
    }

    private void loadCmb() throws IOException {
        List<RoomDto> allRooms = roomBo.findAllRooms();
        roomTYpeCmb.getItems().clear();
        allRooms.forEach(room ->{
            roomTYpeCmb.getItems().add(room.getId()+"."+room.getRoomType());
        });
    }
}
