package com.yashen.d24_hostel.util.converter;

import com.yashen.d24_hostel.dao.custom.UserDao;
import com.yashen.d24_hostel.dto.ReservationDto;
import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.dto.StudentDto;
import com.yashen.d24_hostel.dto.UserDto;
import com.yashen.d24_hostel.entity.Reservation;
import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.entity.Student;
import com.yashen.d24_hostel.entity.User;
import com.yashen.d24_hostel.enums.Gender;
import com.yashen.d24_hostel.enums.RoomType;

public class Converter {
    public Student convertToStudentEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setNic(studentDto.getNic());
        student.setStudentName(studentDto.getStudentName());
        if(studentDto.getGender().equals(Gender.MALE)){
            student.setGender("MALE");
        }else {
            student.setGender("FEMALE");
        }
        student.setMobileNo(studentDto.getMobileNo());
        student.setDob(studentDto.getDob());
        student.setAddress(studentDto.getAddress());
        return student;
    }

    public StudentDto convertToStudentDto(Student student){
        if (student != null){
            System.out.println("---------  nic is -----"+student.getNic()+"----");
            StudentDto studentDto = new StudentDto();
            studentDto.setNic(student.getNic());
            studentDto.setStudentName(student.getStudentName());
            if(student.getGender().equals("MALE")){
                studentDto.setGender(Gender.MALE);
            }else {
                studentDto.setGender(Gender.FEMALE);
            }
            studentDto.setMobileNo(student.getMobileNo());
            studentDto.setDob(student.getDob());
            studentDto.setAddress(student.getAddress());
            return studentDto;
        }else {
            return null;
        }

    }

    public Room convertToRoomEntity(RoomDto roomDto){
        System.out.println("2002   "+", "+roomDto);
        Room room = new Room();
        room.setRoomId(roomDto.getId());
        room.setRoomType(roomDto.getRoomType());
        room.setQty(roomDto.getQty());
        room.setKeyMoney(roomDto.getKeyMoney());
        return room;
    }

    public RoomDto convertToRoomDto(Room room){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getRoomId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setKeyMoney(room.getKeyMoney());
        roomDto.setQty(room.getQty());
        return roomDto;
    }

    public Reservation convertToReservationEntity(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setDate(reservationDto.getDate());
        System.out.println(reservationDto);
        reservation.setRoom(convertToRoomEntity(reservationDto.getRoom()));
        reservation.setStudent(convertToStudentEntity(reservationDto.getStudent()));
        reservation.setStatus(reservationDto.getStatus());
        return reservation;
    }

    public ReservationDto convertToReservationDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getResId());
        reservationDto.setDate(reservation.getDate());
        reservationDto.setRoom(convertToRoomDto(reservation.getRoom()));
        reservationDto.setStudent(convertToStudentDto(reservation.getStudent()));
        reservationDto.setStatus(reservation.getStatus());
        return reservationDto;
    }

    public User convertToUserEntity(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convertToUserDto(User user){
        if (user != null){
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setPassword(user.getPassword());
            userDto.setMobileNumber(user.getMobileNumber());
            return userDto;
        }
        return null;

    }
}
