package com.yashen.d24_hostel.dto;

import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    private String nic;
    private StudentName studentName;
    private Gender gender;
    private String mobileNo;
    private LocalDate dob;
    private String address;
}
