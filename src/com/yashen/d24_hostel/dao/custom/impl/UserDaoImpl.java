package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.UserDao;
import com.yashen.d24_hostel.entity.Student;
import com.yashen.d24_hostel.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(Session session, User user) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        }
        return isSuccess;
    }

    @Override
    public boolean update(Session session, User user) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        } finally {
            session.close();
        }
        return isSuccess;
    }

    @Override
    public User find(Session session, String id) {
        try {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            return user;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Session session, User user) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        } finally {
            session.close();
        }
        return isSuccess;
    }

    @Override
    public List<User> findAll(Session session) {
        List<User> usersList;
        try {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User", User.class);
            usersList = query.getResultList();
            transaction.commit();
            return usersList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> findSelectedUserList(Session session, String text) {
        try {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User u where u.userName like :userName or u.mobileNumber like :mobile",
                    User.class).setParameter("userName","%"+text+"%")
                    .setParameter("mobile","%"+text+"%");
            List<User> usersList = query.getResultList();
            transaction.commit();
            return usersList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
