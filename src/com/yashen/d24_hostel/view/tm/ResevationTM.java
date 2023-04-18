package com.yashen.d24_hostel.view.tm;

import com.yashen.d24_hostel.dto.RoomDto;
import com.yashen.d24_hostel.dto.StudentDto;
import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResevationTM {
    private int id;
    private int no;
    private String student;
    private String roomType;
    private LocalDate date;
    private String status;
    private Button option;
}
