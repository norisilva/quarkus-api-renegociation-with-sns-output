package br.com.nori.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayDomain {
    private String codigoBarra;
    private BigDecimal valorPago;
    private String cpfCnpj;
    private String nomePagador;
    private String emailPagador;
    private String telefonePagador;
    private String enderecoPagador;
    private String dataPagamento;
}