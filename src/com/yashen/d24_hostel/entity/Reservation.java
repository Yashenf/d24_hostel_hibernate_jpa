package com.yashen.d24_hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reservation {
    @Id
    private int resId;
    private LocalDate date;
    @ManyToOne()
    @JoinColumn(
            name = "student"
    )
    private Student student;
    @OneToOne()
    @JoinColumn(
            name = "room"
    )
    private Room room;
    private String status;
}
