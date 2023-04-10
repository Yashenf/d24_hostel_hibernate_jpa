package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.StudentDao;
import com.yashen.d24_hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.Executable;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Session session, Student student) {
        boolean success = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            success = false;
            throw e;
        }
        return success;
    }

    @Override
    public boolean update(Session session, Student student) {
        boolean success = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            success = false;
            throw e;
        }finally {
            session.close();
        }
        return success;
    }

    @Override
    public Student find(Session session, String s) {
        try {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, s);
            transaction.commit();
            return student;
        } catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }

    }

    @Override
    public boolean delete(Session session, Student student) {
        boolean success = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            success = false;
            throw e;
        }finally {
            session.close();
        }
        return success;
    }

    @Override
    public List<Student> findAll(Session session) {
        return null;
    }
}
