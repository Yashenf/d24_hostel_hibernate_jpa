package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.ReservationDao;
import com.yashen.d24_hostel.entity.Reservation;
import com.yashen.d24_hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public boolean save(Session session, Reservation reservation) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        }
        return isSuccess;
    }

    @Override
    public boolean update(Session session, Reservation reservation) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(reservation);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        } finally {
            session.close();
        }
        return isSuccess;
    }

    @Override
    public Reservation find(Session session, Integer id) {
        try {
            Transaction transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, id);
            transaction.commit();
            return reservation;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Session session, Reservation reservation) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        } finally {
            session.close();
        }
        return isSuccess;
    }

    @Override
    public List<Reservation> findAll(Session session) {
        List<Reservation> reservationList;
        try {
            Transaction transaction = session.beginTransaction();
            Query<Reservation> query = session.createQuery("from Reservation", Reservation.class);
            reservationList = query.getResultList();
            transaction.commit();
            return reservationList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
