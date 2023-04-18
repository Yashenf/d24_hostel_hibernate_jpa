package com.yashen.d24_hostel.bo.factory;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.bo.custom.impl.ReservationBoImpl;
import com.yashen.d24_hostel.bo.custom.impl.RoomBoImpl;
import com.yashen.d24_hostel.bo.custom.impl.StudentBoImpl;
import com.yashen.d24_hostel.bo.custom.impl.UserBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getBoFactory (){
        return boFactory == null ?(boFactory= new BoFactory()):boFactory;
    }

    public <T extends SuperBo> T getBo(BoTypes boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBoImpl();
            case ROOM:
                return (T) new RoomBoImpl();
            case RESERVATION:
                return (T) new ReservationBoImpl();
            case USER:
                return (T) new UserBoImpl();
            default:
                return null;
        }
    }
}
