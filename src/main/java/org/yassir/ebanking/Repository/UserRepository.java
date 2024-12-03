package org.yassir.ebanking.Repository;


import org.springframework.stereotype.Repository;
import org.yassir.ebanking.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
