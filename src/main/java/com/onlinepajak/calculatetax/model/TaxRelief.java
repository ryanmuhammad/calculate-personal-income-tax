package com.onlinepajak.calculatetax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaxRelief {

    private String personProfile;

    private String description;

    private Double amount;
}
