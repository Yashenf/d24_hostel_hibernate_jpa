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
            int id = (int) session.save(reservation);
            reservation.setResId(id);
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
            System.out.println("*********************** Come to delete DAO *************************");
            Transaction transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
            System.out.println("*********************** delete DAO Close *************");
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

    @Override
    public List<Reservation> findSelectedReservations(Session session, String text) {
        List studentList;
        try {
            Transaction transaction = session.beginTransaction();
            studentList = session.createQuery("from Reservation r where r.room like :room or r.student like :student or r.status like :status ", Reservation.class
                    ).setParameter("room", "%" + text + "%")
                    .setParameter("student", "%" + text + "%")
                    .setParameter("status", "%" + text + "%")
                    .list();
            transaction.commit();
            return studentList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean changeStatus(Session session, String status, int id) {
        try {
            String hql= "UPDATE Reservation SET status=: new_Status WHERE resId=: reservationId";
            Query query = session.createQuery(hql);
            query.setParameter("new_Status",status);
            query.setParameter("reservationId",id);

            Transaction transaction = session.beginTransaction();
            int i = query.executeUpdate();
            transaction.commit();

            return i > 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }
}
