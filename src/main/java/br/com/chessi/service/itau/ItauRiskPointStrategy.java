package br.com.chessi.service.itau;

import br.com.chessi.model.Product;
import br.com.chessi.service.RiskPointStrategy;
import br.com.chessi.service.itau.chain.BusinessRule;
import br.com.chessi.service.itau.chain.impl.DurationRule;
import br.com.chessi.service.itau.chain.impl.LiquidityRule;
import br.com.chessi.service.itau.chain.impl.MarketRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class ItauRiskPointStrategy implements RiskPointStrategy {

    private final List<BusinessRule> parallelRules;

    public ItauRiskPointStrategy() {
        this.parallelRules = List.of(new LiquidityRule(), new MarketRule());
    }


    @Override
    public RiskPointStrategyType getType() {
        return RiskPointStrategyType.ITAU;
    }

    @Override
    public double calculateRiskPoint(Product product) {
        // Lógica de cálculo para Itaú
        DurationRule durationRule = new DurationRule();
        Double duration = durationRule.apply(product);

        // Execução paralela
        List<CompletableFuture<Double>> futures = parallelRules.stream()
                .filter(rule -> rule.shouldExecute(duration))
                .map(rule -> CompletableFuture.supplyAsync(() -> rule.apply(product)))
                .toList();

        // Agregar resultados das regras paralelas
        Double parallelResult = futures.stream()
                .map(CompletableFuture::join) // Espera pelos resultados
                .reduce(duration, Double::sum);

        return parallelResult; // Exemplo
    }
}