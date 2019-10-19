package com.onlinepajak.calculatetax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaxiationScheme {

    private Integer tierNo;

    private Double rate;

    private Double incomeFrom;

    private Double incomeTo;
}
