package com.cardspayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardspayment.entity.Coustomer;

@Repository
public interface CardspaymentRepository extends JpaRepository<Coustomer,Integer> {
	

}