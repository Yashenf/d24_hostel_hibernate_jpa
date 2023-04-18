package test;

import com.yashen.d24_hostel.bo.custom.ReservationBo;
import com.yashen.d24_hostel.bo.custom.RoomBo;
import com.yashen.d24_hostel.bo.factory.BoFactory;
import com.yashen.d24_hostel.bo.factory.BoTypes;
import com.yashen.d24_hostel.dao.custom.ReservationDao;
import com.yashen.d24_hostel.dao.custom.StudentDao;
import com.yashen.d24_hostel.dao.custom.impl.StudentDaoImpl;
import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import com.yashen.d24_hostel.dao.factory.DaoFactory;
import com.yashen.d24_hostel.dao.factory.DaoTypes;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.entity.Reservation;
import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.entity.Student;
import com.yashen.d24_hostel.enums.Gender;
import com.yashen.d24_hostel.util.converter.Converter;
import org.hibernate.Session;
import org.hibernate.type.LocalDateTimeType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        Session session1 = FactoryConfiguration.getSessionFactory().getSession();
        StudentDao studentDao = new StudentDaoImpl();
        RoomBo roomBo = BoFactory.getBoFactory().getBo(BoTypes.ROOM);
        ReservationDao reservationDao= DaoFactory.getDaoFactory().getDao(DaoTypes.RESERVATION);
        ReservationBo reservationBo= BoFactory.getBoFactory().getBo(BoTypes.RESERVATION);
        /*Student student = new Student();
        student.setStudentName(new StudentName("yash","savindu"));
        student.setAddress("Matugama");
        student.setDob(LocalDate.now());
        student.setMobileNo("0711974973");
        student.setNic("200209303890");
        student.setGender("male");
        boolean save = studentDao.save(session, student);
        System.out.println("Results is : "+save);*/


        /*List<Student> selectedStudents = studentDao.findSelectedStudents(session, "2002");
        System.out.println(selectedStudents.get(0));
        for (Student s :
                selectedStudents) {
            System.out.println(s.getNic()+" , "+s.getStudentName().getFirstName());
        }*/

        /*List<Student> all = studentDao.findAll(session1);
        for (Student s:
             all) {
            System.out.println(s);
        }*/

      /*  Converter converter = new Converter();
        StudentDto studentDto = new StudentDto();
        studentDto.setNic("200209303890");
        studentDto.setGender(Gender.MALE);
        studentDto.setAddress("Matugama");

        Student student = converter.convertToStudentEntity(studentDto);
        System.out.println(student);*/

       /* Room room = new Room();
        String roomType = "14.aaaa";
        String[] split = roomType.split("\\.");
        RoomDto sRoom = roomBo.findSRoom(Integer.parseInt(split[0]));
        System.out.println(sRoom);*/

        /*Student student = studentDao.find(session1, "12345");
        System.out.println(new Converter().convertToStudentDto(student));*/

        ReservationDto sReservation = reservationBo.findSReservation(2);
        boolean isDeleted = reservationBo.deleteReservation(sReservation);
        System.out.println(isDeleted);

        /*boolean b = reservationBo.deleteReservation(reservation);
        System.out.println(b);*/

    }
}
