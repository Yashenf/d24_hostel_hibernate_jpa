package com.yashen.d24_hostel.bo.custom;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.dto.RoomDto;

import java.io.IOException;
import java.util.List;

public interface RoomBo extends SuperBo {
    boolean saveRoom(RoomDto roomDto) throws IOException;
    boolean updateSRoom(RoomDto roomDto) throws IOException;
    boolean deleteRoom(RoomDto roomDto) throws IOException;
    RoomDto findSRoom(int id) throws IOException;
    List<RoomDto> findAllRooms() throws IOException;
    List<RoomDto> findSelectedSRooms(String text);
    boolean updateQty(int id,int qty);
}
