package com.onlinepajak.calculatetax.service.impl;

import com.onlinepajak.calculatetax.model.TaxRelief;
import com.onlinepajak.calculatetax.model.TaxiationScheme;
import com.onlinepajak.calculatetax.repository.TaxReliefRepository;
import com.onlinepajak.calculatetax.repository.TaxiationSchemeRepository;
import com.onlinepajak.calculatetax.service.ITaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxServiceImpl implements ITaxService {

    @Autowired
    private TaxReliefRepository taxReliefRepository;
    @Autowired
    private TaxiationSchemeRepository taxiationSchemeRepository;

    @Override
    public long calculateAnnualTax(Double monthlySalary, String personProfile) {
        double annualTaxableIncome = getAnnualTaxableIncome(monthlySalary, personProfile);
        long annualTaxIncome = getAnnualTaxIncome(annualTaxableIncome);
        return annualTaxIncome;
    }

    private long getAnnualTaxIncome(double annualTaxableIncome) {
        long annualTaxIncome = 0;
        List<TaxiationScheme> taxiationSchemes = taxiationSchemeRepository.findTaxiationSchemes();
        for (TaxiationScheme taxiationScheme : taxiationSchemes) {
            if (annualTaxableIncome == 0) break;

            Double annualTaxableIncomePerScheme;
            if (isSchemeAbove(taxiationScheme.getIncomeTo())) {
                annualTaxableIncomePerScheme = annualTaxableIncome;
                annualTaxableIncome = 0;
            } else {
                double maxIncome = taxiationScheme.getIncomeTo() - taxiationScheme.getIncomeFrom();
                if (annualTaxableIncome > maxIncome) {
                    annualTaxableIncomePerScheme = maxIncome;
                    annualTaxableIncome -= maxIncome;
                } else {
                    annualTaxableIncomePerScheme = annualTaxableIncome;
                    annualTaxableIncome -= annualTaxableIncomePerScheme;
                }
            }

            Double taxPerScheme = annualTaxableIncomePerScheme * taxiationScheme.getRate();
            annualTaxIncome += taxPerScheme.longValue();
        }
        return annualTaxIncome;
    }

    private boolean isSchemeAbove(double incomeTo) {
        return incomeTo == 0;
    }

    private double getAnnualTaxableIncome(Double monthlySalary, String personProfile) {
        int period = 12;
        double annualTaxableIncome = (monthlySalary * period) - getTaxRelief(personProfile);
        if (annualTaxableIncome < 0) return 0;
        else return annualTaxableIncome;
    }

    private double getTaxRelief(String personProfile) {
        return taxReliefRepository.findAll().stream()
                .filter(taxRelief -> taxRelief.getPersonProfile().equalsIgnoreCase(personProfile))
                .map(TaxRelief::getAmount).findAny().orElse(0D);
    }
}
