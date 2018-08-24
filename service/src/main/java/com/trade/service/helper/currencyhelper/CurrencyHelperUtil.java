package com.trade.service.helper.currencyhelper;

import com.trade.service.common.exception.ServiceRuntimeException;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CurrencyHelperUtil {

    private CurrencyHelperUtil() {
        // Private constructor
    }

    public static List<String> getCurrenciesFromPair(final String currencyPair) {
        final List<String> currencyList = new ArrayList<>();
        currencyList.add(currencyPair.substring(0, 3));
        currencyList.add(currencyPair.substring(3, 6));
        return currencyList;
    }

    public static List<CurrencyLocales> getAllCurrencies() {
        final List<LocaleCurrency> localeCurrencies = new ArrayList<>();
        final Locale[] availableLocales = Locale.getAvailableLocales();

        for (final Locale loc : availableLocales) {
            if (loc != null && loc.getLanguage() != null && !loc.getLanguage().equals("")) {
                try {
                    final Currency currency = Currency.getInstance(loc);

                    if (currency != null) {
                        localeCurrencies.add(LocaleCurrency.from(loc, currency.getCurrencyCode()));
                    }
                } catch (final Exception exc) {
                    // Do nothing for missing currency for any locale
                }
            }
        }

        return localeCurrencies.stream().

                collect(Collectors.groupingBy(LocaleCurrency::getCurrency))
                .

                        entrySet().

                        stream()
                .

                        map(currencyGrouping -> CurrencyLocales.from(currencyGrouping.getKey(), currencyGrouping.getValue().

                                stream().

                                map(LocaleCurrency::getLocale).

                                collect(Collectors.toList())))
                .

                        collect(Collectors.toList());
    }


}
