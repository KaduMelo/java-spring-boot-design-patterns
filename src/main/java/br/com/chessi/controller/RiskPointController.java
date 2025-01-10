package br.com.chessi.controller;

import br.com.chessi.model.Product;
import br.com.chessi.service.RiskPointCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/risk-point")
public class RiskPointController {

    private final RiskPointCalculatorService riskPointPipeline;

    public RiskPointController(RiskPointCalculatorService riskPointPipeline) {
        this.riskPointPipeline = riskPointPipeline;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateRiskPoint(@RequestBody Product product) {
        double riskPoint = riskPointPipeline.calculateFinalRiskPoint(product);
        return ResponseEntity.ok(riskPoint);
    }
}
