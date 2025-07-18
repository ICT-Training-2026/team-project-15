package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
    @GetMapping("/export")
    public String showExportView() {
        return "export"; // export.htmlを表示
    }
}