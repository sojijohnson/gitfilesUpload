package com.adesoji.security_test.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String token;

    private Date expirationTime;
    private static final int EXPIRATION_TIME=10;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
    nullable = false,
    foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
    private Users user;


    public VerificationToken(String token, Users user) {
      super();
        this.token = token;
        this.user = user;
        this.expirationTime= calculateExpiration(EXPIRATION_TIME);
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
    }

    private Date calculateExpiration(int expirationTime) {
        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
