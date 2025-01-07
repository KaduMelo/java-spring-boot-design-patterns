package br.com.chessi.service;

import br.com.chessi.model.Product;
import org.springframework.stereotype.Service;

@Service
public class RiskPointPipeline {

//    private final ProprietaryRiskPointStrategy proprietaryStrategy;
//    private final AnbimaRiskPointStrategy anbimaStrategy;
//
//    public RiskPointPipeline(ProprietaryRiskPointStrategy proprietaryStrategy,
//                             AnbimaRiskPointStrategy anbimaStrategy) {
//        this.proprietaryStrategy = proprietaryStrategy;
//        this.anbimaStrategy = anbimaStrategy;
//    }

    public double calculateFinalRiskPoint(Product product) {
//        // Executa os cálculos em paralelo
//        CompletableFuture<Double> proprietaryFuture = CompletableFuture.supplyAsync(() -> proprietaryStrategy.calculateRiskPoint(product));
//        CompletableFuture<Double> anbimaFuture = CompletableFuture.supplyAsync(() -> anbimaStrategy.calculateRiskPoint(product));
//
//        try {
//            // Aguarda os resultados
//            double proprietaryRiskPoint = proprietaryFuture.get();
//            double anbimaRiskPoint = anbimaFuture.get();
//
//            // Aplica a regra de prevalência
//            return proprietaryRiskPoint < anbimaRiskPoint ? anbimaRiskPoint : proprietaryRiskPoint;
//        } catch (Exception e) {
//            throw new RuntimeException("Erro no cálculo de risk points", e);
//        }
        return 0.0;
    }
}
