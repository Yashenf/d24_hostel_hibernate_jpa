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
public class Student implements SuperEntity{
    @Id
    private String nic;
    @Embedded
    private StudentName studentName;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "varchar(255) default 'OTHER'")
    private String gender;
    private String mobileNo;
    private LocalDate dob;
    private String address;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.EAGER
    )
    private List<Reservation> reserveList;
}
