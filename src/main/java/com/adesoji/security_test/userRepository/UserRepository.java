package com.adesoji.security_test.userRepository;

import com.adesoji.security_test.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
