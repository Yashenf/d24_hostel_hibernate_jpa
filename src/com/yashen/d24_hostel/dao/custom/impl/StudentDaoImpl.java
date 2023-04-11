package com.yashen.d24_hostel.dao.custom.impl;

import com.yashen.d24_hostel.dao.custom.StudentDao;
import com.yashen.d24_hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Session session, Student student) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        }
        return isSuccess;
    }

    @Override
    public boolean update(Session session, Student student) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.update(student);
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
    public Student find(Session session, String s) {
        try {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, s);
            transaction.commit();
            return student;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean delete(Session session, Student student) {
        boolean isSuccess = true;
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
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
    public List<Student> findAll(Session session) {
        List<Student> studentList;
        try {
            Transaction transaction = session.beginTransaction();
            Query<Student> query = session.createQuery("from Student", Student.class);
            studentList = query.getResultList();
            transaction.commit();
            return studentList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Student> findSelectedStudents(Session session, String hql) {
        List studentList;
        try {
            Transaction transaction = session.beginTransaction();
            studentList = session.createQuery("from Student s where s.nic like :id or s.gender like :gender or s.studentName.firstName like :firstName or s.studentName.lastName like :lastName or s.mobileNo like :mobileNo or  s.address like :address", Student.class
                    ).setParameter("firstName", "%" + hql + "%")
                    .setParameter("lastName", "%" + hql + "%")
                    .setParameter("address", "%" + hql + "%")
                    .setParameter("gender", "%" + hql + "%")
                    .setParameter("id", "%" + hql + "%")
                    .setParameter("mobileNo", "%" + hql + "%")
                    .list();
            transaction.commit();
            System.out.println(studentList.get(0));
            return studentList;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}

/*
* session.createQuery("from Student s where s.nic= :id or s.gender= :gender " +
                    "or s.studentName.firstName= :firstName or s.studentName.lastName= :lastName or " +
                    "s.mobileNo= :mobileNo or  s.address= :address or s.dob= :dob"
            );
* */