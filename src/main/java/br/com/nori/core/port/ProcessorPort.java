package br.com.nori.core.port;

public interface ProcessorPort {
    String process(String codigoBarra, double valorPago, String email);
}
