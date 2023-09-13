package ks.msx.InternetBanking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String returnLoginPage(){
        return "login";
    }

    @RequestMapping("/register_page")
    public String returnRegisterPage(){
        return "register";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }
}
