package com.trade.service.currency.impl;

import com.trade.persistence.currency.CurrencyRepository;
import com.trade.persistence.currency.entity.Currency;
import com.trade.service.currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Optional<Currency> getByCode(final String code) {
        Assert.notNull(code, "Currency code should not be null when getting Currency by its code");
        return Optional.ofNullable(currencyRepository.findByCode(code));
    }
}
