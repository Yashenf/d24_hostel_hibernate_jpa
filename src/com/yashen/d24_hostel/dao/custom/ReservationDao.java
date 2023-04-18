package com.yashen.d24_hostel.dao.custom;

import com.yashen.d24_hostel.dao.CrudDao;
import com.yashen.d24_hostel.entity.Reservation;
import org.hibernate.Session;

import java.util.List;

public interface ReservationDao extends CrudDao<Reservation,Integer> {
    List<Reservation> findSelectedReservations (Session session , String text);
    boolean changeStatus(Session session, String status, int id);
}
