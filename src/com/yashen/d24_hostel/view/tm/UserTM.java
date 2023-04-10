package com.yashen.d24_hostel.view.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTM {
    private int no;
    private String name;
    private String mobile;
    private String job;
    private Button option;
}
