package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.entity.Currency;
import ks.msx.InternetBanking.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public List<Currency> returnAllCurrencyDetails(){
        return currencyRepository.findAll();
    }

    public float calcExchange(String From, Float sum, String To){
        float currencyFrom = currencyRepository.findCurrencyByType(From).orElseThrow().getCurrent_price_sale();
        float currencyTo = currencyRepository.findCurrencyByType(To).orElseThrow().getCurrent_price_buy();
        return (currencyFrom*sum)/currencyTo;
    }
}
