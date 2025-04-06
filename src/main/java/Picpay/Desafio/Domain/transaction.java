package Picpay.Desafio.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Transaction")
public class transaction {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User send;
    @ManyToOne
    private User recevi;
    private BigDecimal value;




}
