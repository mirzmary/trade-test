package com.trade.api.client.common;

import javax.ws.rs.client.Client;

public class AbstractResourceClient {

    //region Properties
    private String apiPath;

    private Client client;
    //endregion

    //region Constructors
    public AbstractResourceClient() {
    }

    public AbstractResourceClient(final Client client, final String apiPath) {
        this.apiPath = apiPath;
        this.client = client;
    }
    //endregion

    //region Properties getters and setters
    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(final String apiPath) {
        this.apiPath = apiPath;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }
    //endregion
}
