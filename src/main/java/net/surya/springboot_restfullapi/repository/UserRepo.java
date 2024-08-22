package net.surya.springboot_restfullapi.repository;

import net.surya.springboot_restfullapi.dto.UserDto;
import net.surya.springboot_restfullapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
