package com.onlinepajak.calculatetax.repository;

import com.onlinepajak.calculatetax.model.TaxiationScheme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxiationSchemeRepository {

    public List<TaxiationScheme> findTaxiationSchemes(){
        List<TaxiationScheme> taxiationSchemes = new ArrayList<>();
        taxiationSchemes.add(new TaxiationScheme(1, 0.05, 0D, 50000000D));
        taxiationSchemes.add(new TaxiationScheme(2, 0.15, 50000000D, 250000000D));
        taxiationSchemes.add(new TaxiationScheme(3, 0.25, 250000000D, 500000000D));
        taxiationSchemes.add(new TaxiationScheme(4, 0.3, 500000000D, 0D));
        return taxiationSchemes;
    }
}
