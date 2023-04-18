package com.yashen.d24_hostel.bo.custom.impl;

import com.yashen.d24_hostel.bo.custom.ReservationBo;
import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.dao.custom.ReservationDao;
import com.yashen.d24_hostel.dao.custom.RoomDao;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.dao.factory.DaoFactory;
import com.yashen.d24_hostel.dao.factory.DaoTypes;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.entity.Reservation;
import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.util.converter.Converter;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBoImpl implements ReservationBo {

    Converter converter = new Converter();
    ReservationDao reservationDao = DaoFactory.getDaoFactory().getDao(DaoTypes.RESERVATION);
    RoomDao roomDao= DaoFactory.getDaoFactory().getDao(DaoTypes.ROOM);

    @Override
    public boolean saveReservation(ReservationDto reservationDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        Session session2 = FactoryConfiguration.getSessionFactory().getSession();
        Transaction transaction = session.beginTransaction();
        // transaction process
        // check qty
        RoomDto room = reservationDto.getRoom();
        int roomId = room.getId();
        Room selectedRoom = roomDao.find(session2, roomId);
        int qty = selectedRoom.getQty();
        if (room.getQty() >= qty){
            boolean isSaved = reservationDao.save(session, converter.convertToReservationEntity(reservationDto));
            if (isSaved){
                return roomDao.updateQty(session, transaction, roomId, qty - 1);
            }
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Qty is not match").show();
        }
        return false;
    }

    @Override
    public boolean updateReservation(ReservationDto reservationDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return reservationDao.update(session, converter.convertToReservationEntity(reservationDto));
    }

    @Override
    public boolean deleteReservation(ReservationDto reservationDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        System.out.println("*************************** delete BO ***************");
        System.out.println("*********************"+reservationDto);
        return reservationDao.delete(session, converter.convertToReservationEntity(reservationDto));
    }

    @Override
    public ReservationDto findSReservation(int id) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return converter.convertToReservationDto(reservationDao.find(session, id));
    }

    @Override
    public List<ReservationDto> findAllReservations() throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<Reservation> all = reservationDao.findAll(session);
        List<ReservationDto> dtoList = new ArrayList<>();
        for (Reservation r: all){
            dtoList.add(
                    converter.convertToReservationDto(r)
            );
        }
        return dtoList;
    }

    @Override
    public List<ReservationDto> findSelectedReservations(String text) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<Reservation> all = reservationDao.findSelectedReservations(session,text);
        List<ReservationDto> dtoList = new ArrayList<>();
        for (Reservation r: all){
            dtoList.add(
                    converter.convertToReservationDto(r)
            );
        }
        return dtoList;
    }

    @Override
    public boolean changeStatus(String status, int id) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return reservationDao.changeStatus(session,status,id);
    }
}
