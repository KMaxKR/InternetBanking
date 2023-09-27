package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.entity.Card;
import ks.msx.InternetBanking.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class P2PService {
    private final CardRepository cardRepository;

    public Card findCardByCardCode(String code){
        return cardRepository.findCardByCode(code).orElseThrow(() -> new IllegalStateException("Wrong Card Code"));
    }

    public Card findCardByFirstname(String firstname){
        return cardRepository.findCardByFirstname(firstname).orElseThrow(() -> new UsernameNotFoundException("Wrong Firstname"));
    }

    public void p2pTransfer(){
        /*
            TODO: p2pTransfer card by card
         */
    }
}
