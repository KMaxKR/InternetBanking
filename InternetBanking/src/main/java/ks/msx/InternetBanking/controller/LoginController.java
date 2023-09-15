package ks.msx.InternetBanking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String returnLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/api/v1/main/login", method = RequestMethod.POST)
    public void logInUser(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
            HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.login(username, password);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/register_page", method = RequestMethod.GET)
    public String returnRegisterPage(){
        return "register";
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout();
        response.sendRedirect("/");
    }

}
