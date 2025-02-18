package com.finproj.banking_application.Repository;

import com.finproj.banking_application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Boolean existsByEmail(String email);
}
