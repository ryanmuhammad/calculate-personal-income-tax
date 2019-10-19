package com.onlinepajak.calculatetax.controller;

import com.onlinepajak.calculatetax.service.ITaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculatetax")
public class CalculateTaxController {

    @Autowired
    private ITaxService taxService;

    @GetMapping("/annual")
    public long calculateAnnualTax(@RequestParam double monthlySalary, @RequestParam String personProfile){
        return taxService.calculateAnnualTax(monthlySalary, personProfile);
    }
}
