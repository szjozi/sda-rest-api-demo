package com.sda.restdemo.repositories;

import com.sda.restdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM users u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("DELETE FROM users u WHERE u.username = :username")
    void deleteByUsername(String username);
}
