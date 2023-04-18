package com.yashen.d24_hostel.bo.custom;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.dto.UserDto;

import java.io.IOException;
import java.util.List;

public interface UserBo extends SuperBo {
    boolean saveUser(UserDto userDto) throws IOException;
    boolean updateUser(UserDto userDto) throws IOException;
    boolean deleteUser(UserDto userDto) throws IOException;
    UserDto findSUser(String username) throws IOException;
    List<UserDto> findAllUsers() throws IOException;
    List<UserDto> findSelectedUsers(String text) throws IOException;
}
