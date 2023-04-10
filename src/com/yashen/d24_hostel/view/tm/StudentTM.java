package com.yashen.d24_hostel.view.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentTM{
    private int no;
    private String name;
    private String nic;
    private String mobile;
    private Button option;
}
