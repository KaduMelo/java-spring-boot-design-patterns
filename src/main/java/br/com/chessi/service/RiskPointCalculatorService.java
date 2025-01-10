package br.com.chessi.service;

import br.com.chessi.model.Product;
import br.com.chessi.service.anbima.AnbimaRiskPointStrategy;
import br.com.chessi.service.itau.ItauRiskPointStrategy;
import br.com.chessi.service.itau.RiskPointStrategyType;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class RiskPointCalculatorService {

    private final RiskPointStrategyRegistry registry;

    public RiskPointCalculatorService(RiskPointStrategyRegistry registry) {
        this.registry = registry;
    }

    public double calculateFinalRiskPoint(Product product) {
        // Busca estratégias pelo enum
        RiskPointStrategy itauStrategy = registry.getStrategy(RiskPointStrategyType.ITAU);
        RiskPointStrategy anbimaStrategy = registry.getStrategy(RiskPointStrategyType.ANBIMA);

        // Executa os cálculos em paralelo
        CompletableFuture<Double> itauFuture = CompletableFuture.supplyAsync(() -> itauStrategy.calculateRiskPoint(product));
        CompletableFuture<Double> anbimaFuture = CompletableFuture.supplyAsync(() -> anbimaStrategy.calculateRiskPoint(product));

        try {
            // Aguarda os resultados
            double itauRiskPoint = itauFuture.get();
            double anbimaRiskPoint = anbimaFuture.get();

            // Aplica a regra de prevalência
            return itauRiskPoint < anbimaRiskPoint ? anbimaRiskPoint : itauRiskPoint;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular os risk points", e);
        }
    }
}
