package kz.aparking.authservice.user.jpa;

import kz.aparking.authservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findByPhone(String phone);

    boolean existsByPhone(String phone);

    User findByPhone(String phone);
}
