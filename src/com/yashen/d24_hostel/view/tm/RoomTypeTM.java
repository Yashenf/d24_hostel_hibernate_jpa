package com.yashen.d24_hostel.view.tm;

import com.yashen.d24_hostel.util.enums.RoomTypes;
import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomTypeTM {
    private int no;
    private int id;
    private String roomType;
    private double keyMoney;
    private int qty;
    private int qtyOnHand;
    private Button option;
}
