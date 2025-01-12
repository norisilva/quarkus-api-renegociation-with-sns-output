package br.com.nori.rest.controller;

import br.com.nori.business.processor.PayProcessor;
import br.com.nori.core.port.ProcessorPort;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;

@Path("/pay")
public class PayController {

    @Inject
    ProcessorPort processor;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String handler(@QueryParam("codigoBarra") String codigoBarra, @QueryParam("valorPago") double valorPago, @QueryParam("email") String email) {
        return processor.process(codigoBarra, valorPago, email);
    }
}