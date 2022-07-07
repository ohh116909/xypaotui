package com.zhang.xypaotui.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String Id;
    private String Email;
    private String Username;
    private String Password;
    private String Salt;
    private String Telephone;
    private LocalDateTime CreatTime;
}
