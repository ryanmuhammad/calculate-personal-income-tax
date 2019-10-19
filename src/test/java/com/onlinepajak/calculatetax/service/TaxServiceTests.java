package com.onlinepajak.calculatetax.service;

import com.onlinepajak.calculatetax.repository.TaxReliefRepository;
import com.onlinepajak.calculatetax.repository.TaxiationSchemeRepository;
import com.onlinepajak.calculatetax.service.impl.TaxServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaxServiceTests {

    @Spy
    private TaxReliefRepository taxReliefRepository;
    @Spy
    private TaxiationSchemeRepository taxiationSchemeRepository;
    @InjectMocks
    private TaxServiceImpl taxService;

    @Test
    public void given50000000AndTK0_whenCalculateAnnualTax_thenReturn108800000() {
        //given
        double monthlySalary = 50000000;
        String personProfile = "TK0";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 108800000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given50000000AndK0_whenCalculateAnnualTax_thenReturn107450000() {
        //given
        double monthlySalary = 50000000;
        String personProfile = "K0";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 107450000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given50000000AndK1_whenCalculateAnnualTax_thenReturn106100000() {
        //given
        double monthlySalary = 50000000;
        String personProfile = "K1";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 106100000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given50000000AndK2_whenCalculateAnnualTax_thenReturn104750000() {
        //given
        double monthlySalary = 50000000;
        String personProfile = "K2";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 104750000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void given50000000AndK3_whenCalculateAnnualTax_thenReturn103400000() {
        //given
        double monthlySalary = 50000000;
        String personProfile = "K3";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 103400000;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }

    @Test
    public void givenAnnualTaxableIncomeLessThan0_whenCalculateAnnualTax_thenReturn0() {
        //given
        double monthlySalary = 1000000;
        String personProfile = "TK0";

        //when
        long actualAnnualTax = taxService.calculateAnnualTax(monthlySalary, personProfile);

        //then
        long expectedAnnualTax = 0;
        assertEquals(expectedAnnualTax, actualAnnualTax);
    }
}
