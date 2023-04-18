package com.yashen.d24_hostel.bo.custom;

import com.yashen.d24_hostel.bo.SuperBo;
import com.yashen.d24_hostel.dto.StudentDto;

import java.io.IOException;
import java.util.List;

public interface StudentBo extends SuperBo {
    boolean saveStudent(StudentDto studentDto) throws IOException;
    boolean updateStudent(StudentDto studentDto) throws IOException;
    boolean deleteStudent(StudentDto studentDto) throws IOException;
    StudentDto findStudent(String id) throws IOException;
    List<StudentDto> findAllStudent() throws IOException;
    List<StudentDto> findSelectedStudents(String text) throws IOException;

}
