package ks.msx.InternetBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    private final String username;

    private final String first_name;

    private final String last_name;

    private final String password;

    private final String email;
}
