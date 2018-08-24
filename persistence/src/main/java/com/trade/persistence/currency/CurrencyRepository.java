package com.trade.persistence.currency;

import com.trade.persistence.currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Long> {

    Currency findByCode(final String code);
}
