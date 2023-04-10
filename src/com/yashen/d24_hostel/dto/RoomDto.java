package com.yashen.d24_hostel.dto;

import com.yashen.d24_hostel.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDto {
    private RoomType roomType;
    private double keyMoney;
    private int qty;
}
