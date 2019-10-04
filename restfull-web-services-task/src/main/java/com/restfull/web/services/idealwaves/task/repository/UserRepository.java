package com.restfull.web.services.idealwaves.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfull.web.services.idealwaves.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
