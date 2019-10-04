package com.restfull.web.services.idealwaves.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.restfull.web.services.idealwaves.task.entity.UserContact;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact, Long>{
	List<UserContact> findByUserId(Long userId);
	 Optional<UserContact> findByIdAndUserId(Long id, Long userId);
}

