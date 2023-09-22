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
}
