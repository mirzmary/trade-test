package com.trade.api.client.trade.impl;

import com.trade.api.client.common.AbstractResourceClient;
import com.trade.api.client.trade.TradeResourceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;

public class TradeResourceClientImpl extends AbstractResourceClient implements TradeResourceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeResourceClientImpl.class);

    private static final String RESOURCE_BASE_PATH = "trade";

    public TradeResourceClientImpl(final Client client, final String apiPath) {
        super(client, apiPath);
        LOGGER.debug("Initializing trade client");
    }
}
