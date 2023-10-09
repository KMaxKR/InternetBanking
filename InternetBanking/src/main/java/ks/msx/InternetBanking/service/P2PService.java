package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.dto.p2pDTO;
import ks.msx.InternetBanking.entity.Card;
import ks.msx.InternetBanking.entity.P2PDatabase;
import ks.msx.InternetBanking.entity.StatusOperation;
import ks.msx.InternetBanking.repository.CardRepository;
import ks.msx.InternetBanking.repository.CurrencyRepository;
import ks.msx.InternetBanking.repository.P2PRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class P2PService {
    private final CardRepository cardRepository;
    private final P2PRepository p2PRepository;
    private final CurrencyRepository currencyRepository;
    private final CurrencyService currencyService;

    public Card findCardByCardCode(String code){
        return cardRepository.findCardByCode(code).orElseThrow(() -> new IllegalStateException("Wrong Card Code"));
    }

    public Card findCardByFirstname(String firstname){
        return cardRepository.findCardByFirstname(firstname).orElseThrow(() -> new UsernameNotFoundException("Wrong Firstname"));
    }

    public void p2pTransfer(p2pDTO dto){
        Card cardDonor = cardRepository.findCardByCode(dto.getDonor_card_code())
                .orElseThrow(() -> new IllegalStateException("Wrong Donor Card Code"));
        Card cardReceiver = cardRepository.findCardByCode(dto.getReceiver_card_code())
                .orElseThrow(() -> new IllegalStateException("Wrong Receiver Card Code"));

        Long receiverValueType = currencyRepository.findCurrencyByType(dto.getAmount_type()).orElseThrow().getId();
        Long donorValueType = currencyRepository.findCurrencyByType(String.valueOf(cardDonor.getValue_type())).orElseThrow().getId();

        if (confirmData(dto)){
            p2PRepository.save(
                    P2PDatabase.builder()
                            .donor_id(cardDonor.getUser_card_id())
                            .donor_card_id(cardDonor.getId())
                            .receiver_id(cardReceiver.getUser_card_id())
                            .receiver_card_id(cardReceiver.getId())
                            // TODO: at the moment its only approved,
                            //  but must to be denied
                            //  only after confirmation will be changed to approved
                            .status(StatusOperation.APPROVED)
                            .sum(dto.getAmount())
                            .donor_value_type(donorValueType)
                            .receiver_value_type(receiverValueType)
                            .build()
            );

            cardRepository.save(
                    Card.builder()
                            .id(cardDonor.getId())
                            .firstname(cardDonor.getFirstname())
                            .lastname(cardDonor.getLastname())
                            .code(cardDonor.getCode())
                            .card_cvv(cardDonor.getCard_cvv())
                            .card_expire_date(cardDonor.getCard_expire_date())
                            .value_type(cardDonor.getValue_type())
                            .available_amount(cardDonor.getAvailable_amount() - currencyService.calcExchange(dto.getAmount_type(), dto.getAmount(), String.valueOf(cardDonor.getValue_type())))
                            .user_card_id(cardDonor.getUser_card_id())
                            .build()
            );
            cardRepository.save(
              Card.builder()
                      .id(cardReceiver.getId())
                      .firstname(cardReceiver.getFirstname())
                      .lastname(cardReceiver.getLastname())
                      .code(cardReceiver.getCode())
                      .card_cvv(cardReceiver.getCard_cvv())
                      .card_expire_date(cardReceiver.getCard_expire_date())
                      .value_type(cardReceiver.getValue_type())
                      .available_amount(cardReceiver.getAvailable_amount() + currencyService.calcExchange(dto.getAmount_type(), dto.getAmount(), String.valueOf(cardReceiver.getValue_type())))
                      .user_card_id(cardReceiver.getUser_card_id())
                      .build()
            );
        }
    }

    public boolean confirmData(p2pDTO dto){
        Card cardDonor = cardRepository.findCardByCode(dto.getDonor_card_code())
                .orElseThrow(() -> new IllegalStateException("Wrong Donor Card Code"));
        Card cardReceiver = cardRepository.findCardByCode(dto.getReceiver_card_code())
                .orElseThrow(() -> new IllegalStateException("Wrong Receiver Card Code"));

        Date cardRepoDate = cardDonor.getCard_expire_date();
        Date cardInputDate = dto.getDonor_card_expire_date();

        return dto.getAmount() >= cardDonor.getAvailable_amount() &&
                dto.getDonor_card_firstname().equals(cardDonor.getFirstname()) &&
                dto.getDonor_card_lastname().equals(cardDonor.getLastname()) &&
                dto.getReceiver_card_firstname().equals(cardReceiver.getFirstname()) &&
                dto.getReceiver_card_lastname().equals(cardReceiver.getLastname()) &&
                cardRepoDate == cardInputDate;
    }
}
