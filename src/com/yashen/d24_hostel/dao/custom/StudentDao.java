package com.yashen.d24_hostel.dao.custom;

import com.yashen.d24_hostel.dao.CrudDao;
import com.yashen.d24_hostel.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDao extends CrudDao<Student,String> {
    List<Student> findSelectedStudents(Session session, String hql);
}
