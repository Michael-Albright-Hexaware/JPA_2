package com.albright.ms.JPA_2.repository;

import com.albright.ms.JPA_2.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
}
