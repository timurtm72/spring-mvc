package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Controller
public class CalculateController {
    @GetMapping("/calculate")
    public String calculateResult(@RequestParam(value = "num1", required = false) double num1,
                                  @RequestParam(value = "num2", required = false) double num2,
                                  @RequestParam(value = "operation", required = false) String operation,
                                  Model model) {
        double res = 0;
        String op = null;
        switch (operation) {
            case "add":
                res = num1 + num2;
                op = "+";
                break;
            case "sub":
                res = num1 - num2;
                op = "-";
                break;
            case "mull":
                res = num1 * num2;
                op = "*";
                break;
            case "div":
                res = num1 / num2;
                op = "/";
                break;
            default:
                res = 0;
                op = "?";
                break;
        }
        NumberFormat formatter = new DecimalFormat("#0.00");
        model.addAttribute("result", num1 + " " + op + " " + num2 + " = " + formatter.format(res));
        return "calculate";
    }
}
