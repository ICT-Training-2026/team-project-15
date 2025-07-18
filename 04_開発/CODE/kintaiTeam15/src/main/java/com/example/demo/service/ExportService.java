package com.example.demo.service;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExportService {
	Workbook createExcelWorkbook(String month);
}
