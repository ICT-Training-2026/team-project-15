package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class WorkInfoDto {
	private String id;
    private Date date;
    private int workstyle;
    private Time starttime;
    private Time endtime;
    private double breaktime;
    private double worktime;
    private double overtime;
}
