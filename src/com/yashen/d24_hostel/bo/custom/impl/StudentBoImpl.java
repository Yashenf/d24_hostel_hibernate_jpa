package com.yashen.d24_hostel.bo.custom.impl;

import com.yashen.d24_hostel.bo.custom.StudentBo;
import com.yashen.d24_hostel.dao.custom.StudentDao;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.dao.factory.DaoFactory;
import com.yashen.d24_hostel.dao.factory.DaoTypes;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.entity.Student;
import com.yashen.d24_hostel.util.converter.Converter;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    Converter converter = new Converter();
    StudentDao studentDao = DaoFactory.getDaoFactory().getDao(DaoTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDto studentDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return studentDao.save(session, converter.convertToStudentEntity(studentDto));
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return studentDao.update(session, converter.convertToStudentEntity(studentDto));
    }

    @Override
    public boolean deleteStudent(StudentDto studentDto) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return studentDao.delete(session, converter.convertToStudentEntity(studentDto));
    }

    @Override
    public StudentDto findStudent(String id) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        return converter.convertToStudentDto(studentDao.find(session, id));
    }

    @Override
    public List<StudentDto> findAllStudent() throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<Student> all = studentDao.findAll(session);
        List<StudentDto> dtoList = new ArrayList();
        for (Student s:
             all) {
               dtoList.add(converter.convertToStudentDto(s));
        }
        return dtoList;
    }

    @Override
    public List<StudentDto> findSelectedStudents(String text) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        List<Student> all = studentDao.findSelectedStudents(session,text);
        List<StudentDto> dtoList = new ArrayList();
        for (Student s:
                all) {
            dtoList.add(converter.convertToStudentDto(s));
        }
        return dtoList;
    }
}
