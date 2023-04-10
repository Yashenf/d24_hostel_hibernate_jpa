package com.yashen.d24_hostel.entity;

import com.yashen.d24_hostel.enums.RoomType;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Room implements SuperEntity{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int roomId;
    @Enumerated(
            EnumType.STRING
    )
    private RoomType roomType;
    private double keyMoney;
    private int qty;
}
