package com.hugosPetShop.petShop.springboot.repository;

import com.hugosPetShop.petShop.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

}
