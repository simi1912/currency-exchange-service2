package com.simi.microservicesv2.currencyexchangeservice2;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ExchangeController {

    private Environment environment;
    private CurrencyExchangeRepo repo;

    public ExchangeController(Environment environment, CurrencyExchangeRepo repo) {
        this.environment = environment;
        this.repo = repo;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to){

        CurrencyExchange currencyExchange = repo.getByFromAndTo(from, to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

        return currencyExchange;
    }

}
