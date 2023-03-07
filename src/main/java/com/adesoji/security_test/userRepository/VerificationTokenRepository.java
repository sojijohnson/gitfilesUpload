package com.adesoji.security_test.userRepository;

import com.adesoji.security_test.user.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {
}
