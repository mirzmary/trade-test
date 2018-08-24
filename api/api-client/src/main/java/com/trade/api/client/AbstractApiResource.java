package com.trade.api.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;


public class AbstractApiResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Client client;
    private final WebTarget rootTarget;
    private static final String COMMON_DELIMITER = "/";


    protected AbstractApiResource(final Client client, final WebTarget rootTarget, final String pathSuffix) {
        Assert.notNull(client, "Client should not be null");
        Assert.notNull(rootTarget, "Root target should not be null");
        Assert.hasText(pathSuffix, "PathSuffix should not be null");

        String finalPathSuffix = pathSuffix;
        if (!COMMON_DELIMITER.equals(pathSuffix.substring(0, 1))) {
            finalPathSuffix = COMMON_DELIMITER + pathSuffix;
        }

        this.client = client;
        this.rootTarget = rootTarget.path(finalPathSuffix);
    }

    /**
     * Warning: Resources returned by this method should be manually closed!
     *
     * @param path
     * @return
     */
    protected Response doGet(final String path) {
        WebTarget target = rootTarget.path(path);

        logger.debug("Doing GET request to {}", target.getUri());

        Response r = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        checkResponseError(r, target);
        return r;
    }

    protected <T> T doGet(final String path, final Class<T> entityType) {
        Response response = null;

        try {
            response = doGet(path);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    protected <T> T doGet(final String path, final GenericType<T> entityType) {
        Response response = null;

        try {
            response = doGet(path);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    /**
     * Warning: Resources returned by this method should be manually closed!
     *
     * @param path
     * @param queryParams
     * @return
     */
    protected Response doGet(final String path, Map<String, String> queryParams) {
        WebTarget target = rootTarget.path(path);
        if (queryParams != null) {
            for (Map.Entry<String, String> e : queryParams.entrySet())
                target = target.queryParam(e.getKey(), e.getValue());
        }

        logger.debug("Doing GET request to {}", target.getUri());

        Response r = target.request().get();
        checkResponseError(r, target);
        return r;
    }

    protected <T> T doGet(final String path, final Class<T> entityType, Map<String, String> queryParams) {
        Response response = null;

        try {
            response = doGet(path, queryParams);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    protected <T> T doGet(final String path, final GenericType<T> entityType, Map<String, String> queryParams) {
        Response response = null;

        try {
            response = doGet(path, queryParams);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    /**
     * Warning: Resources returned by this method should be manually closed!
     *
     * @param path
     * @return
     */
    protected Response doPost(final String path, final Object data) {
        WebTarget target = rootTarget.path(path);

        logger.debug("Doing POST request to {}", target.getUri());

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(data, MediaType.APPLICATION_JSON), Response.class);

        checkResponseError(response, target);
        return response;
    }

    protected <T> T doPost(String path, Object data, Class<T> entityType) {
        Response response = null;

        try {
            response = doPost(path, data);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    protected <T> T doPost(final String path, final Object data, final GenericType<T> entityType) {
        Response response = null;

        try {
            response = doPost(path, data);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    /**
     * Warning: Resources returned by this method should be manually closed!
     *
     * @param path
     * @return
     */
    protected Response doPut(final String path, final Object data) {
        WebTarget target = rootTarget.path(path);

        logger.debug("Doing PUT request to {}", target.getUri());

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(data, MediaType.APPLICATION_JSON), Response.class);

        checkResponseError(response, target);
        return response;
    }

    protected <T> T doPut(String path, Object data, Class<T> entityType) {
        Response response = null;

        try {
            response = doPut(path, data);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    protected <T> T doPut(final String path, final Object data, final GenericType<T> entityType) {
        Response response = null;

        try {
            response = doPut(path, data);
            return response.readEntity(entityType);
        } finally {
            closeResponse(response);
        }
    }

    private void checkResponseError(final Response response, final WebTarget target) {

        if (response.getStatus() == 200) {
            return;
        }

        try {
            response.bufferEntity();

            logger.warn("Error during http response processing on request to {}", target.getUri());

        } catch (Exception e) {
            throw new WebApplicationException();
        }
    }

    private void closeResponse(final Response r) {
        try {

            if (r != null) {
                r.close();
            }
        } catch (Exception e) {
            logger.debug("Error when closing the response object", e);
            // Do nothing here
        }
    }
}
