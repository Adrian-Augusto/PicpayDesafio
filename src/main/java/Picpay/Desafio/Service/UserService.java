package Picpay.Desafio.Service;

import Picpay.Desafio.Domain.UserType;
import Picpay.Desafio.Domain.Users;
import Picpay.Desafio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void ValidationTransaction(Users send, BigDecimal value) throws Exception {
        if (UserType.Usuario_Lojista.equals(send.getUserType())) {
            throw new Exception("USUÁRIO TIPO LOJISTA NÃO ESTÁ AUTORIZADO A REALIZAR TRANSAÇÃO");
        }
        if (send.getValue().compareTo(value) < 0) {
            throw new Exception("SALDO INSUFICIENTE");
        }
    }

    public Users findById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado com o ID: " + id));
    }

    public  Users CreateUser(Users users){
        return  this.userRepository.save(users);
    }

}
