package br.com.chessi.service.itau.chain.impl;

import br.com.chessi.model.Product;
import br.com.chessi.service.itau.chain.BusinessRule;

import java.math.BigDecimal;

public class MarketRule implements BusinessRule {

    @Override
    public boolean shouldExecute(Double value) {
        return !value.isNaN();
    }

    @Override
    public Double apply(Product product) {
        // Busca market
        return 10.0;
    }
}