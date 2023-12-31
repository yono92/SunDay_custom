package com.sunday.sundaycustom.repository;

import com.sunday.sundaycustom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);

    User findByUserId(String userId);

}
