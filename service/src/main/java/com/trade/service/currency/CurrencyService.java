package com.trade.service.currency;

import com.trade.persistence.currency.entity.Currency;

import java.util.Optional;

public interface CurrencyService {

    Optional<Currency> getByCode(final String code);
}
