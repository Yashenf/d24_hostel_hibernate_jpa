package com.yashen.d24_hostel.dto;

import com.yashen.d24_hostel.entity.Room;
import com.yashen.d24_hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {
    private int id;
    private LocalDate date;
    private StudentDto student;
    private RoomDto room;
    private String status;
}
