package com.adesoji.security_test.event;

import com.adesoji.security_test.user.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {




    private  final  Users user;
    private  final String applicationUrl;


    public RegistrationCompleteEvent(Users user, String applicationUrl) {
        super(user);
        this.applicationUrl=applicationUrl;
        this.user =user;

    }
}
