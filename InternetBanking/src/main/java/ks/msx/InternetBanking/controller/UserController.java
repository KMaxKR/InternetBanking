package ks.msx.InternetBanking.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ks.msx.InternetBanking.dto.UserDTO;
import ks.msx.InternetBanking.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final RegistrationService registrationService;

    @PostMapping("/api/v1/main/register")
    public void firstStepRegister(UserDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        registrationService.registration(dto);
        request.login(dto.getUsername(), dto.getPassword());
        response.sendRedirect("/");
    }
}
