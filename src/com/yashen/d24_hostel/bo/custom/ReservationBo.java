package com.yashen.d24_hostel.bo.custom;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;

import java.io.IOException;
import java.util.List;

public interface ReservationBo extends SuperBo {
    boolean saveReservation(ReservationDto reservationDto) throws IOException;
    boolean updateReservation(ReservationDto reservationDto) throws IOException;
    boolean deleteReservation(ReservationDto reservationDto) throws IOException;
    ReservationDto findSReservation(int id) throws IOException;
    List<ReservationDto> findAllReservations() throws IOException;
    List<ReservationDto> findSelectedReservations(String text) throws IOException;
    boolean changeStatus(String status, int id) throws IOException;
}
