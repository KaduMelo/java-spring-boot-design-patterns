package br.com.chessi.service.itau.chain;

import br.com.chessi.model.Product;

import java.math.BigDecimal;

public interface BusinessRule {
    boolean shouldExecute(Double value);

    Double apply(Product product);
}
