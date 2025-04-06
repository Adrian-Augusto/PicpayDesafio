package Picpay.Desafio.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.usertype.UserType;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Users")
public class Users {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;
    private  String password;
    private UserType userType;
    public BigDecimal value;





}


