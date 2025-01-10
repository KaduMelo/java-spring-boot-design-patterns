package br.com.chessi.service.itau.chain.impl;

import br.com.chessi.model.Product;
import br.com.chessi.service.itau.chain.BusinessRule;

import java.math.BigDecimal;

public class LiquidityRule implements BusinessRule {

    @Override
    public boolean shouldExecute(Double value) {
        return !value.isNaN();
    }

    @Override
    public Double apply(Product product) {
        // Busca liquidity
        return 30.0;
    }
}
