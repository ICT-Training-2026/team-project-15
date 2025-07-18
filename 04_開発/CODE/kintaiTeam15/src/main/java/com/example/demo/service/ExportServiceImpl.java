package com.example.demo.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.repository.WorkInfoDto;
import com.example.demo.repository.WorkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExportServiceImpl implements ExportService {
	
	private final WorkRepository exportRepository;
	

	@Override
	public Workbook createExcelWorkbook(String month) { // 出力するExcelファイルの作成
		List<WorkInfoDto> dataList = exportRepository.exportWorkInfo(month);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("データ");
        
        //ヘッダー行の作成
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("社員番号");
        header.createCell(1).setCellValue("日付");
        header.createCell(2).setCellValue("勤務区分");
        header.createCell(3).setCellValue("始業時刻");
        header.createCell(4).setCellValue("終業時刻");
        header.createCell(5).setCellValue("休憩時間");
        header.createCell(6).setCellValue("実労働時間");
        header.createCell(7).setCellValue("累積超過時間");

        //データ行の作成
        int rowIdx = 1;
        for (WorkInfoDto data : dataList) {
         Row row = sheet.createRow(rowIdx++);
         row.createCell(0).setCellValue(data.getId());
         row.createCell(1).setCellValue(data.getDate() != null ? data.getDate().toString() : "");
         row.createCell(2).setCellValue(data.getWorkstyle());
         row.createCell(3).setCellValue(data.getStarttime() != null ? data.getStarttime().toString() : "");
         row.createCell(4).setCellValue(data.getEndtime() != null ? data.getEndtime().toString() : "");
         row.createCell(5).setCellValue(data.getBreaktime());
         row.createCell(6).setCellValue(data.getWorktime());
         row.createCell(7).setCellValue(data.getOvertime());
        }
        return workbook;
  }
}

