package ks.msx.InternetBanking.service;

import ks.msx.InternetBanking.entity.User;
import ks.msx.InternetBanking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND_MSG = "USER WITH THAT USERNAME %s NOT FOUND";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    public void signUpUser(User user){
        boolean isPresent = userRepository.findUserByUsername(user.getUsername()).isPresent();
        if (isPresent) throw new IllegalStateException("Username already exists");
        userRepository.save(user);
    }

    public void enableUser(Long user_id){
        User user = userRepository.findById(user_id).orElseThrow();
        user.setEnable(true);
        userRepository.save(user);
    }
}
