package ks.msx.InternetBanking.controller;

import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.dto.ExchangeDTO;
import ks.msx.InternetBanking.dto.p2pDTO;
import ks.msx.InternetBanking.service.CurrencyService;
import ks.msx.InternetBanking.service.P2PService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BankingController {
    private final CurrencyService currencyService;
    private final P2PService p2PService;

    public static double calc;

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
    public void p2pTransfer(@RequestBody p2pDTO dto, HttpServletResponse response) throws IOException {
        p2PService.p2pTransfer(dto);
        // TODO: its must be redirect to confirm page where will be approving the transfer,
        //  and only after redirect to main page
        response.sendRedirect("/");
    }
}
