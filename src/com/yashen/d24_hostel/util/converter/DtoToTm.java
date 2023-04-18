package com.yashen.d24_hostel.util.converter;

import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.dto.UserDto;
import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.view.tm.ResevationTM;
import com.yashen.d24_hostel.view.tm.RoomTypeTM;
import com.yashen.d24_hostel.view.tm.StudentTM;
import com.yashen.d24_hostel.view.tm.UserTM;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DtoToTm {
    StudentBo studentBo = BoFactory.getBoFactory().getBo(BoTypes.STUDENT);
    RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);


    public ArrayList<StudentTM> convertStudentDtoToStudentTmList(List<StudentDto> list) {
        ArrayList<StudentTM> tmList = new ArrayList();
        int no = 0;
        for (StudentDto dto : list) {
            StudentTM studentTM = new StudentTM();
            studentTM.setNo(++no);
            studentTM.setName(dto.getStudentName().getFirstName() + " " + dto.getStudentName().getLastName());
            studentTM.setNic(dto.getNic());
            studentTM.setMobile(dto.getMobileNo());
            Button delete = new Button("Delete");
            /*delete.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "are you sure whether do you want to delete this customer?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    try {
                        if (studentBo.deleteStudent(dto)) {
                            new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            });*/
            studentTM.setOption(delete);
            tmList.add(studentTM);
        }
        return tmList;
    }


    public ArrayList<RoomTypeTM> convertToRoomDtoToRoomTm(List<RoomDto> list) {
        ArrayList<RoomTypeTM> tmList = new ArrayList<>();
        int no = 0;
        for (RoomDto room: list) {
            RoomTypeTM roomTypeTM = new RoomTypeTM();
            roomTypeTM.setId(room.getId());
            roomTypeTM.setNo(++no);
            roomTypeTM.setKeyMoney(room.getKeyMoney());
            roomTypeTM.setQty(room.getQty());
            Button delete = new Button("Delete");
            /*delete.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "are you sure whether do you want to delete this customer?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    try {
                        if (roomBo.deleteRoom(room)) {
                            new Alert(Alert.AlertType.INFORMATION, "Room Deleted!").show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            });*/
            roomTypeTM.setOption(delete);
            roomTypeTM.setRoomType(room.getRoomType());
            tmList.add(roomTypeTM);

        }
        return tmList;
    }

    public ArrayList<ResevationTM> convertToReservationDtoToTm(List<ReservationDto> reserveList){
        ArrayList<ResevationTM> resevationTMArrayList = new ArrayList<>();
        AtomicInteger no = new AtomicInteger(); // error in per-increment
        reserveList.forEach(r->{
            ResevationTM reservationTM = new ResevationTM();
            reservationTM.setId(r.getId());
            reservationTM.setNo(no.incrementAndGet());
            reservationTM.setRoomType(r.getRoom().getRoomType());
            reservationTM.setStatus(r.getStatus());
            reservationTM.setStudent(r.getStudent().getStudentName().getFirstName()+" "+
                    r.getStudent().getStudentName().getFirstName() );
            reservationTM.setDate(r.getDate());
            reservationTM.setStatus(r.getStatus());
            reservationTM.setOption(new Button("END"));
            resevationTMArrayList.add(reservationTM);
        });
        return resevationTMArrayList;
    }

    public ArrayList<UserTM> convertToUserDtoToTm(List<UserDto> userList){
        ArrayList<UserTM> userTMS = new ArrayList<>();
        int no= 0;
        for (UserDto u:
             userList) {
            UserTM userTM = new UserTM();
            userTM.setNo(++no);
            userTM.setName(u.getUserName());
            userTM.setMobile(u.getMobileNumber());
            userTM.setJob("Manager");
            userTM.setOption(new Button("Delete"));
            userTMS.add(userTM);
        }
        return userTMS;
    }
}



/*
*
* new Button("Delete").setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "are you sure whether do you want to delete this customer?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    try {
                        if (studentBo.deleteStudent(dto)) {
                            new Alert(Alert.AlertType.INFORMATION, "Customer Deleted!").show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            })
*
* */