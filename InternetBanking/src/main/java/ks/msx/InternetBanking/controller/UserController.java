package ks.msx.InternetBanking.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.dto.UserDTO;
import ks.msx.InternetBanking.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final RegistrationService registrationService;

    @PostMapping("/api/v1/main/register")
    public void firstStepRegister(UserDTO dto, HttpServletResponse response) throws IOException, MessagingException {
        registrationService.registration(dto);
        response.sendRedirect("/");
    }

    /*
    Confirmation with token what is sent to user email
     */
    @RequestMapping(value = "/api/v1/main/confirm/token={confirmToken}")
    public void confirmUserToken(@PathVariable(name = "confirmToken")String token, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        registrationService.confirmationToken(token);
        response.sendRedirect("/");
        request.login(registrationService.returnUserByToken(token).getUsername(), registrationService.returnUserByToken(token).getPassword());
    }
}
