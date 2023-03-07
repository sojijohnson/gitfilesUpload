package com.adesoji.security_test.userController;


import com.adesoji.security_test.event.RegistrationCompleteEvent;
import com.adesoji.security_test.user.Users;
import com.adesoji.security_test.userService.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class UserController {
    @Autowired
    ApplicationEventPublisher publisher;
    @Autowired
    UserService userService;
  @GetMapping("/test")
  public String TestUser(){

      return "hello word";
  }
    @PostMapping("/register")
    public String RegisterUser(@RequestBody Users user, final HttpServletRequest request) {


        Users users = userService.RegisterUser(user);
        publisher.publishEvent(new RegistrationCompleteEvent(
                users, applicationUrl(request)));

        return "success";


    }

    private String applicationUrl(HttpServletRequest request) {

        return "http://" + request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath();
    }
}