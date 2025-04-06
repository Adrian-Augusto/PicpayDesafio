package Picpay.Desafio.TransactionDTO;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long SenderID, Long ReceivID ) {
}
