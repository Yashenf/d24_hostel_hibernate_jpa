package com.yashen.d24_hostel.controller.resevation;

import com.yashen.d24_hostel.bo.custom.ReservationBo;
import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.dto.StudentDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewResevationFormController implements Initializable {
    ResevationFormController resevationFormController;
    ReservationBo reservationBo = BoFactory.getBoFactory().getBo(BoTypes.RESERVATION);
    StudentBo studentBo = BoFactory.getBoFactory().getBo(BoTypes.STUDENT);
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);

    @FXML
    private AnchorPane context;

    @FXML
    private TextField nicTxt;

    @FXML
    private ComboBox<String> roomTYpeCmb;

    @FXML
    private DatePicker datePkr;

    @FXML
    private TextField statusTxt;

    @FXML
    void makeResevationBtnOnAction(ActionEvent event) throws IOException {
        String value = roomTYpeCmb.getValue();
        String[] split = value.split("\\.");
        System.out.println("--------------- rrom id is ------ "+split[0]);
        RoomDto sRoom = roomBo.findSRoom(Integer.parseInt(split[0]));
        System.out.println(sRoom);
        StudentDto student = studentBo.findStudent(nicTxt.getText().trim());
        if (student == null){
            new Alert(Alert.AlertType.ERROR,"Student's Nic is Not Registered!").show();
            return;
        }
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(Integer.parseInt(split[0]));
        reservationDto.setStudent(student);
        reservationDto.setStatus(statusTxt.getText());
        reservationDto.setDate(datePkr.getValue());
        reservationDto.setRoom(sRoom);

        boolean b = reservationBo.saveReservation(reservationDto);
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Reservation Saved!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Not Saved!").show();
        }
        resevationFormController.setData();

    }

    public void init (ResevationFormController resevationFormController){
        this.resevationFormController = resevationFormController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initRoomCmb();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initRoomCmb() throws IOException {
        List<RoomDto> allRooms = roomBo.findAllRooms();
        roomTYpeCmb.getItems().clear();
        allRooms.forEach(room ->{
            roomTYpeCmb.getItems().add(room.getId()+"."+room.getRoomType());
        });
    }
}
