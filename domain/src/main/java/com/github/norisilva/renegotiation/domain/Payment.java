package com.github.norisilva.renegotiation.domain;

import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@NoArgsConstructor
class Payment {

    private String codigoBarra;
    private BigDecimal valorPago;
    private String cpfCnpj;
}
