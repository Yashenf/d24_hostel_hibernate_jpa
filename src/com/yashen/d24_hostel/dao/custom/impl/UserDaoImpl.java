package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.UserDao;
import com.yashen.d24_hostel.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(Session session, User user) {
        return false;
    }

    @Override
    public boolean update(Session session, User user) {
        return false;
    }

    @Override
    public User find(Session session, Integer integer) {
        return null;
    }

    @Override
    public boolean delete(Session session, User user) {
        return false;
    }

    @Override
    public List<User> findAll(Session session) {
        return null;
    }
}
