package com.example.demo.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class WorkRepositoryImpl implements WorkRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<WorkInfoDto> exportWorkInfo(String month) {
        String sql = "SELECT * FROM WORKINFO WHERE DATE_FORMAT(DATE, '%Y-%m') = ?";
        return jdbcTemplate.query(
            sql,
            new Object[]{month},
            (rs, rowNum) -> {
                WorkInfoDto dto = new WorkInfoDto();
                dto.setId(rs.getString("ID"));
                dto.setDate(rs.getDate("DATE"));
                dto.setWorkstyle(rs.getInt("WORKSTYLE"));
                dto.setStarttime(rs.getTime("STARTTIME"));
                dto.setEndtime(rs.getTime("ENDTIME"));
                dto.setBreaktime(rs.getDouble("BREAKTIME"));
                dto.setWorktime(rs.getDouble("WORKTIME"));
                dto.setOvertime(rs.getDouble("OVERTIME"));
                return dto;
            }
        );
    }
}

    