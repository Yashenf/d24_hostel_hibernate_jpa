package com.yashen.d24_hostel.dao.factory;

import com.yashen.d24_hostel.dao.SuperDao;
import com.yashen.d24_hostel.dao.custom.impl.ReservationDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.RoomDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.StudentDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {  //getInstance
        return daoFactory == null ? (daoFactory = new DaoFactory()) : daoFactory;
    }

    public <T extends SuperDao> T getDao(DaoTypes daoType) {
        switch (daoType) {
            case STUDENT:
                return (T) new StudentDaoImpl();
            case ROOM:
                return (T) new RoomDaoImpl();
            case RESERVATION:
                return (T) new ReservationDaoImpl();
            case USER:
                return (T) new UserDaoImpl();
            default:
                return null;
        }
    }
}
