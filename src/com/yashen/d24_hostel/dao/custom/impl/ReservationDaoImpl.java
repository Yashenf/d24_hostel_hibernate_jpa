package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.ReservationDao;
import com.yashen.d24_hostel.entity.Reservation;
import org.hibernate.Session;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public boolean save(Session session, Reservation reservation) {
        return false;
    }

    @Override
    public boolean update(Session session, Reservation reservation) {
        return false;
    }

    @Override
    public Reservation find(Session session, Integer integer) {
        return null;
    }

    @Override
    public boolean delete(Session session, Reservation reservation) {
        return false;
    }

    @Override
    public List<Reservation> findAll(Session session) {
        return null;
    }
}
