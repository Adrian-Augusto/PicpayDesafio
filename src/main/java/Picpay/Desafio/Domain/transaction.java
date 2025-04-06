package Picpay.Desafio.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Transaction")
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User send;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User recevi;

    private LocalDateTime timestamp;



}
