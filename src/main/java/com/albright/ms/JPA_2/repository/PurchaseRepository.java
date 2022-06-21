package com.albright.ms.JPA_2.repository;

import com.albright.ms.JPA_2.entity.Lease;
import com.albright.ms.JPA_2.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, BigDecimal> {

}
