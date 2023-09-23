package ks.msx.InternetBanking.controller;

import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.service.CurrencyService;
import ks.msx.InternetBanking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    private final CurrencyService currencyService;

    /*
     *  Auto redirect to main
     */

    @GetMapping()
    public void redirectToMain(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/v1/main");
    }

    @RequestMapping("/api/v1/main")
    public String getMainPage(Model model){
        if (SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("anonymoususer")){
            model.addAttribute("auth", false);
        }
        else {
            model.addAttribute("auth", true);
        }
        model.addAttribute("currency", currencyService.returnAllCurrencyDetails());
        model.addAttribute("result", BankingController.calc);
        return "main";
    }
}
