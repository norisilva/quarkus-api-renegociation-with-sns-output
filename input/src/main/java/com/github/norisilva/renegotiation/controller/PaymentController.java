package com.github.norisilva.renegotiation.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/payment")
public class PaymentController {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String handler(@QueryParam("codigoBarra") String codigoBarra, @QueryParam("valorPago") double valorPago, @QueryParam("email") String email) {
        return "Valor pago: " + valorPago + " para o código de barras: " + codigoBarra + ". Aguarde o processamento, você recebrá uma mensagem com o comprovante no email: " + email;
    }
}