package com.yashen.d24_hostel.bo.custom.impl;

import com.yashen.d24_hostel.bo.custom.RoomBo;

import com.yashen.d24_hostel.dao.custom.RoomDao;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.dao.factory.DaoFactory;
import com.yashen.d24_hostel.dao.factory.DaoTypes;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.entity.Room;

import com.yashen.d24_hostel.util.converter.Converter;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBo {

    Converter converter = new Converter();
    RoomDao roomDao = DaoFactory.getDaoFactory().getDao(DaoTypes.ROOM);

    @Override
    public boolean saveRoom(RoomDto roomDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return roomDao.save(session, converter.convertToRoomEntity(roomDto));
    }

    @Override
    public boolean updateSRoom(RoomDto roomDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return roomDao.update(session, converter.convertToRoomEntity(roomDto));
    }

    @Override
    public boolean deleteRoom(RoomDto roomDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return roomDao.delete(session, converter.convertToRoomEntity(roomDto));
    }

    @Override
    public RoomDto findSRoom(int id) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        Room room = roomDao.find(session, id);
        return converter.convertToRoomDto(room);
    }

    @Override
    public List<RoomDto> findAllRooms() throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<Room> all = roomDao.findAll(session);
        List<RoomDto> dtoList = new ArrayList();
        for (Room r: all){
            dtoList.add(converter.convertToRoomDto(r));
        }
        return dtoList;
    }

    @Override
    public List<RoomDto> findSelectedSRooms(String text) {
        return null;
    }

    @Override
    public boolean updateQty( int id, int qty) { // create for transaction process
        return false;
    }
}
