package com.adesoji.security_test.userService;

import com.adesoji.security_test.user.Users;
import com.adesoji.security_test.user.VerificationToken;
import com.adesoji.security_test.userRepository.UserRepository;
import com.adesoji.security_test.userRepository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    public Users RegisterUser(Users user) {
           Users users =new Users();
             users.setFirstname(user.getFirstname());
             users.setLastname(user.getLastname());
             users.setPassword(user.getPassword());
         userRepository.save(users);

           return users;
    }

    public void saveVerificationToken(String token, Users users) {

        VerificationToken verificationToken = new VerificationToken(token, users);
    verificationTokenRepository.save(verificationToken);
    }
}
