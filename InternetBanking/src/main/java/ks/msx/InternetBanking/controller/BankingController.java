package ks.msx.InternetBanking.controller;

import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.dto.ExchangeDTO;
import ks.msx.InternetBanking.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BankingController {
    private final CurrencyService currencyService;

    public static float calc;

    @RequestMapping("/api/v1/main/exchange")
    public void returnExchangeCalc(@RequestBody ExchangeDTO exchangeDTO,
                               HttpServletResponse response) throws IOException {
        calc = currencyService.calcExchange(
                exchangeDTO.getTypeFrom(),
                exchangeDTO.getSum(),
                exchangeDTO.getTypeTo());
        response.sendRedirect("/");
    }

    @RequestMapping(name = "/api/v1/main/p2p/transfer")
    public void p2pTransfer(){
        /*
            TODO: endpoint: save the operation in db and transfer amount to receiver
         */
    }
}
