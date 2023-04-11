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
        student.setGender(studentDto.getGender() == Gender.MALE ? "MALE" : "FEMALE");
        student.setMobileNo(studentDto.getMobileNo());
        student.setDob(studentDto.getDob());
        student.setAddress(studentDto.getAddress());
        return student;
    }

    public StudentDto convertToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setNic(student.getNic());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setGender(student.getGender().equalsIgnoreCase("MALE")?Gender.MALE:Gender.FEMALE);
        studentDto.setMobileNo(student.getMobileNo());
        studentDto.setDob(student.getDob());
        studentDto.setAddress(student.getAddress());
        return studentDto;
    }

    public Room convertToRoomEntity(RoomDto roomDto){
        Room room = new Room();
        switch (roomDto.getRoomType()){
            case ACNONFOOD:
                room.setRoomType("A/C Non Foods");
            case ACWITHFOOD:
                room.setRoomType("A/C With Foods");
            case NONACNONFOOD:
                room.setRoomType("Non A/C Non Food");
            case NONACWITHFOOD:
                room.setRoomType("Non A/c With Food");
            default:
                room.setRoomType("Not Specified");
        }
        room.setQty(roomDto.getQty());
        room.setKeyMoney(roomDto.getKeyMoney());
        return room;
    }

    public RoomDto convertToRoomDto(Room room){
        RoomDto roomDto = new RoomDto();
        switch (room.getRoomType()){
            case "A/C Non Foods":
                roomDto.setRoomType(RoomType.ACNONFOOD);
            case "A/C With Foods":
                roomDto.setRoomType(RoomType.ACWITHFOOD);
            case "Non A/C Non Food":
                roomDto.setRoomType(RoomType.NONACNONFOOD);
            case "Non A/c With Food":
                roomDto.setRoomType(RoomType.NONACWITHFOOD);
            default:
                roomDto.setRoomType(RoomType.NONACNONFOOD);
        }
        roomDto.setKeyMoney(room.getKeyMoney());
        roomDto.setQty(room.getQty());
        return roomDto;
    }

    public Reservation convertToReservationEntity(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setDate(reservationDto.getDate());
        reservation.setRoom(reservationDto.getRoom());
        reservation.setStudent(reservationDto.getStudent());
        reservation.setStatus(reservationDto.getStatus());
        return reservation;
    }

    public ReservationDto convertToReservationDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDate(reservation.getDate());
        reservationDto.setRoom(reservation.getRoom());
        reservationDto.setStudent(reservation.getStudent());
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
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setMobileNumber(user.getMobileNumber());
        return userDto;
    }
}
