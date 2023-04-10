package com.yashen.d24_hostel.view.tm;

import com.yashen.d24_hostel.dto.RoomTypeDto;
import com.yashen.d24_hostel.dto.StudentDto;
import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResevationTM {
    private int no;
    private StudentDto student;
    private RoomTypeDto roomType;
    private Date date;
    private String status;
    private Button option;
}
