package com.onlinepajak.calculatetax.service;

public interface ITaxService {

    long calculateAnnualTax(Double monthlySalary, String personProfile);
}
