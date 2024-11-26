package com.education.nawamaga.repo;

import com.education.nawamaga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserName(String username);
}
