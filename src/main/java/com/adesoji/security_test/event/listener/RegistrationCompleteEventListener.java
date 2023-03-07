package com.adesoji.security_test.event.listener;

import com.adesoji.security_test.event.RegistrationCompleteEvent;
import com.adesoji.security_test.user.Users;
import com.adesoji.security_test.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.UUID;
@Slf4j
public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {


private UserService userService;
    @Override


    public void onApplicationEvent(RegistrationCompleteEvent event) {
        Users users =event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(token, users); //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);


    }
}
