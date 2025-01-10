package br.com.chessi.service;

import br.com.chessi.model.Product;
import br.com.chessi.service.itau.RiskPointStrategyType;

public interface RiskPointStrategy {
    RiskPointStrategyType getType(); // Retorna o tipo da estratégia (e.g., "ITAU", "ANBIMA")
    double calculateRiskPoint(Product product);
}