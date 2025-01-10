package br.com.chessi.service.anbima;

import br.com.chessi.model.Product;
import br.com.chessi.service.RiskPointStrategy;
import br.com.chessi.service.itau.RiskPointStrategyType;
import org.springframework.stereotype.Component;

@Component
public class AnbimaRiskPointStrategy implements RiskPointStrategy {

    @Override
    public RiskPointStrategyType getType() {
        return RiskPointStrategyType.ANBIMA;
    }

    @Override
    public double calculateRiskPoint(Product product) {
        // Lógica de cálculo para Anbima
        return 20.0; // Exemplo
    }
}