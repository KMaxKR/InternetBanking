package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.dto.UserDTO;
import ks.msx.InternetBanking.entity.Role;
import ks.msx.InternetBanking.entity.User;
import ks.msx.InternetBanking.utility.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final static String DEFAULT_USER_ICON = "https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/corporate-user-icon.png";

    public void registration(UserDTO dto){
        boolean isValidEmail = emailValidator.test(dto.getEmail());
        if (!isValidEmail) throw new IllegalStateException("Email not valid");
        userService.signUpUser(User.builder()
                .username(dto.getUsername())
                .first_name(dto.getFirst_name())
                .last_name(dto.getLast_name())
                .password(new BCryptPasswordEncoder(12).encode(dto.getPassword()))
                .email(dto.getEmail())
                .icon(DEFAULT_USER_ICON)
                .role(Role.USER)
                .account_non_locked(true)
                .build()
        );
    }
}
