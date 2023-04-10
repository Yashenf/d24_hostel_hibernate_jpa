package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.RoomDao;
import com.yashen.d24_hostel.entity.Room;
import org.hibernate.Session;

import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public boolean save(Session session, Room room) {
        return false;
    }

    @Override
    public boolean update(Session session, Room room) {
        return false;
    }

    @Override
    public Room find(Session session, Integer integer) {
        return null;
    }

    @Override
    public boolean delete(Session session, Room room) {
        return false;
    }

    @Override
    public List<Room> findAll(Session session) {
        return null;
    }
}
