package com.yashen.d24_hostel.bo.custom.impl;

import com.yashen.d24_hostel.bo.custom.UserBo;
import com.yashen.d24_hostel.dao.custom.UserDao;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.dao.factory.DaoFactory;
import com.yashen.d24_hostel.dao.factory.DaoTypes;
import com.yashen.d24_hostel.dto.UserDto;
import com.yashen.d24_hostel.entity.User;
import com.yashen.d24_hostel.util.converter.Converter;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {
    Converter converter = new Converter();
    UserDao userDao = DaoFactory.getDaoFactory().getDao(DaoTypes.USER);
    @Override
    public boolean saveUser(UserDto userDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return userDao.save(session, converter.convertToUserEntity((userDto)));
    }

    @Override
    public boolean updateUser(UserDto userDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return userDao.update(session, converter.convertToUserEntity((userDto)));
    }

    @Override
    public boolean deleteUser(UserDto userDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return userDao.delete(session, converter.convertToUserEntity((userDto)));
    }

    @Override
    public UserDto findSUser(String username) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return converter.convertToUserDto(userDao.find(session,username));
    }

    @Override
    public List<UserDto> findAllUsers() throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<User> all = userDao.findAll(session);
        List<UserDto> dtoList = new ArrayList<>();
        for (User u: all){
            dtoList.add(converter.convertToUserDto(u));
        }
        return dtoList;
    }

    @Override
    public List<UserDto> findSelectedUsers(String text) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<User> selectedUserList = userDao.findSelectedUserList(session, text);
        List<UserDto> dtoList = new ArrayList<>();
        for (User u: selectedUserList){
            dtoList.add(converter.convertToUserDto(u));
        }
        return dtoList;
    }
}
