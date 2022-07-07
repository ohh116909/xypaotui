package com.zhang.xypaotui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Take {
    private String forId;
    private String forName;
    private String forAbout;
    private String forAdress;
    private LocalDateTime forOverTime;
    private double forMoney;
    private String forQQ;
    private String forWx;
    private String forPhone;
    private String forCode;
    private String forIdname;
    private LocalDateTime forBeginTime;
    private String forGetAdress;
}
