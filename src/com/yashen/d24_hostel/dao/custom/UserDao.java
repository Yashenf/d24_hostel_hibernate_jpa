package com.yashen.d24_hostel.dao.custom;

import com.yashen.d24_hostel.dao.CrudDao;
import com.yashen.d24_hostel.entity.User;
import org.hibernate.Session;

import java.util.List;

public interface UserDao extends CrudDao<User,String> {
    List<User> findSelectedUserList(Session session, String text);
}
