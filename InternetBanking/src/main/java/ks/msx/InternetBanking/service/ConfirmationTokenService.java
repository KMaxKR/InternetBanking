package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.entity.Token;
import ks.msx.InternetBanking.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveToken(String token, Long user_id){
        confirmationTokenRepository.save(Token.builder()
                        .token(token)
                        .user_id(user_id)
                .build());
    }

    public Token getToken(String token){
        return confirmationTokenRepository.findByToken(token).orElseThrow(() -> new IllegalStateException("Wrong Token"));
    }

    public void setConfirmAt(String token){
        Token token1 = getToken(token);
        token1.setConfirmed(true);
        confirmationTokenRepository.save(token1);
    }
}
