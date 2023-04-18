package com.yashen.d24_hostel.dao.custom;

import com.yashen.d24_hostel.dao.CrudDao;
import com.yashen.d24_hostel.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface RoomDao extends CrudDao<Room,Integer> {
    boolean updateQty(Session session, Transaction transaction, int id, int qty);
}
