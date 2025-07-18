package com.example.demo.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ExportService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ExportController {
	private final ExportService exportService;

    @GetMapping("/exportExcel")
    public void exportExcel(@RequestParam("month") String month,
                           HttpServletResponse response) throws IOException {

        Workbook workbook = exportService.createExcelWorkbook(month);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=export.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}