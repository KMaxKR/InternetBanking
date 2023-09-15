package ks.msx.InternetBanking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.dto.UserDTO;
import ks.msx.InternetBanking.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final RegistrationService registrationService;

    @PostMapping("/api/v1/main/register")
    public void firstStepRegister(UserDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        registrationService.registration(dto);
        //request.login(dto.getUsername(), dto.getPassword());
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/api/v1/main/confirm", method = RequestMethod.POST)
    public void confirmUserToken(@RequestParam(name = "token")String token){
        registrationService.confirmationToken(token);
    }
}
