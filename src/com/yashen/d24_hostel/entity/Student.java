package com.yashen.d24_hostel.entity;

import com.yashen.d24_hostel.embedded.StudentName;
import com.yashen.d24_hostel.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    private String nic;
    @Embedded
    private StudentName studentName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String mobileNo;
    private LocalDate dob;
    private String address;

    @OneToMany(
            mappedBy = "student"
    )
    private List<Reservation> reserveList;
}
