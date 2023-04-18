package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.RoomDao;
import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public boolean save(Session session, Room room) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            int id = (int) session.save(room);
            room.setRoomId(id);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        }
        return isSuccess;
    }

    @Override
    public boolean update(Session session, Room room) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(room);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        }
        return isSuccess;
    }

    @Override
    public Room find(Session session, Integer id) {
        try {
            Transaction transaction = session.beginTransaction();
            Room room = session.get(Room.class, id);
            transaction.commit();
            return room;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Session session, Room room) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(room);
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
    public List<Room> findAll(Session session) {
        List<Room> roomList;
        try {
            Transaction transaction = session.beginTransaction();
            Query<Room> query = session.createQuery("from Room", Room.class);
            roomList = query.getResultList();
            transaction.commit();
            return roomList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateQty(Session session, Transaction transaction, int id, int qty) {
        try {
            String hql= "UPDATE Room SET qty= :qty WHERE roomId=:id";
            Query query = session.createQuery(hql);
            query.setParameter("qty",qty);
            query.setParameter("id",id);
            int i = query.executeUpdate();
            transaction.commit();
            return i>0;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;

    }
}
