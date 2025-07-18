// User.java (エンティティクラス)
package com.example.demo.entity;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 勤怠情報
public class WorkInfo {
    private String id;
    private Date date;
    private String name;
    private int workstyle;
    private Time startTime;
    private Time endTime;
    private float breakTime;
    private float workTime;
    private float overTime;
    
}