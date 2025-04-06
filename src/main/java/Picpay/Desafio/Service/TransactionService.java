package Picpay.Desafio.Service;

import Picpay.Desafio.Domain.Users;
import Picpay.Desafio.TransactionDTO.TransactionDTO;
import Picpay.Desafio.Repository.TransactionRepository;
import Picpay.Desafio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.StyledEditorKit;
import java.math.BigDecimal;
import java.util.Map;

public class TransactionService {

    @Autowired
    private UserService UserService;

    @Autowired
    private TransactionRepository TransactionRepository;

    @Autowired
    private RestTemplate restTemplate;



    public void createTransaction(TransactionDTO transactionDTO) throws Exception {
        Users sender = this.UserService.findById(transactionDTO.SenderID());

        Users recive = this.UserService.findById(transactionDTO.ReceivID());

        // ... lógica para continuar a transação
        UserService.ValidationTransaction(sender,transactionDTO.value());

        boolean isAuthorize = this.authorizeTransaction(sender, transactionDTO.value())
        if (!isAuthorize){
            throw new Exception("Transacao n Autorizada");
        }
        transactionDTO transaction = new Transac


    }
    public Boolean authorizeTransaction(Users send, BigDecimal value) {
        ResponseEntity<Map> authorizeResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if (authorizeResponse.getStatusCode() == HttpStatus.OK && authorizeResponse.hasBody()) {
            Map body = authorizeResponse.getBody();
            if (body != null && "Autorizado".equalsIgnoreCase((String) body.get("message"))) {
                return true;
            }
        }

        return false;
    }}
