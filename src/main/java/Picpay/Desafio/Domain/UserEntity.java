package Picpay.Desafio.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@Entity
@Table(name = "Users")
public class UserEntity {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;
    private  String password;





}


