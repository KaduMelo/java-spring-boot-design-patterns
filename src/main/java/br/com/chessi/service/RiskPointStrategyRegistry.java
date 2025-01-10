package br.com.chessi.service;

import br.com.chessi.service.itau.RiskPointStrategyType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RiskPointStrategyRegistry {

    private final Map<RiskPointStrategyType, RiskPointStrategy> strategies;

    public RiskPointStrategyRegistry(List<RiskPointStrategy> strategyList) {
        // Converte a lista em um mapa com base no nome da estratégia
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(RiskPointStrategy::getType, strategy -> strategy));
    }

    public RiskPointStrategy getStrategy(RiskPointStrategyType type) {
        return strategies.get(type);
    }
}
