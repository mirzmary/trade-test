package com.trade.api.rest.resources.trade;

import com.trade.api.model.common.ResponseListModel;
import com.trade.api.model.trade.TradeValidationRequestModel;
import com.trade.api.model.trade.TradeValidationResponseModel;
import com.trade.facade.trade.TradeFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trade")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "User resource", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
public class TradeResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeResource.class);

    @Autowired
    private TradeFacade tradeFacade;

    @GET
    @Path("/test")
    @ApiOperation(value = "API Say Hello", notes = "This is just an test API to check if Server is working", response = Response.class)
    public String hello() {
        return "Hello";
    }

    @POST
    @Path("/validate")
    @ApiOperation(value = "API Say Hello", notes = "Validating trade data", response = Response.class)
    public Response validateTradeList(final List<TradeValidationRequestModel> tradeValidationRequestModelList, @Context final HttpServletRequest requestContext) {
        LOGGER.debug("Processing trade list validation request - {}", tradeValidationRequestModelList);
        final ResponseListModel<TradeValidationResponseModel> response = tradeFacade.validateTradeList(tradeValidationRequestModelList);
        LOGGER.debug("Trade list validation processed successfully for trade list - {}, with response - {}", tradeValidationRequestModelList, response);
        return Response.ok(response).build();
    }
}
