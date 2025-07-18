package com.example.demo.repository;

import java.util.List;

public interface WorkRepository {
	List<WorkInfoDto> exportWorkInfo(String month);
}
