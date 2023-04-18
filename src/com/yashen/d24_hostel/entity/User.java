package com.yashen.d24_hostel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class User implements SuperEntity{
    @Id
    private String userName;
    private String mobileNumber;
    private String password;
}
