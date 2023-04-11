package com.yashen.d24_hostel.dao.factory;

import com.yashen.d24_hostel.dao.SuperDao;
import com.yashen.d24_hostel.dao.custom.impl.ReservationDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.RoomDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.StudentDaoImpl;
import com.yashen.d24_hostel.dao.custom.impl.UserDaoImpl;

public class DaoFactory {
    private static  DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){  //getInstance
        return daoFactory == null ? (daoFactory= new DaoFactory()):daoFactory;
    }

    public SuperDao getDao(DaoTypes daoType){
        switch (daoType){
            case STUDENT:
                return new StudentDaoImpl();
            case ROOM:
                return new RoomDaoImpl();
            case RESERVATION:
                return new ReservationDaoImpl();
            case USER:
                return new UserDaoImpl();
            default:
                return null;
        }
    }
}
