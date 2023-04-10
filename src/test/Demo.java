package test;

import com.yashen.d24_hostel.dao.custom.StudentDao;
import com.yashen.d24_hostel.dao.custom.impl.StudentDaoImpl;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.entity.Student;
import com.yashen.d24_hostel.enums.Gender;
import org.hibernate.Session;
import org.hibernate.type.LocalDateTimeType;

import java.io.IOException;
import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setStudentName(new StudentName("yash","savindu"));
        student.setAddress("Matugama");
        student.setDob(LocalDate.now());
        student.setMobileNo("0711974973");
        student.setNic("200209303890");
        student.setGender(Gender.MALE);
        boolean save = studentDao.save(session, student);
        System.out.println("Results is : "+save);
    }
}
