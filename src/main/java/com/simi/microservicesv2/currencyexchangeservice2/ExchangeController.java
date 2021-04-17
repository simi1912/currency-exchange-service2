package com.simi.microservicesv2.currencyexchangeservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to){

        return new CurrencyExchange(
                1L, "USD", "RON", BigDecimal.valueOf(4.5));

    }

}
