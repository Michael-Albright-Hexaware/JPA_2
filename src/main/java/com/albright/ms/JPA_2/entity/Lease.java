package com.albright.ms.JPA_2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lease extends Mobile {
    private BigDecimal leaseRatePerMonth;

    public Lease(String mobileCompany, String mobileName, BigDecimal leaseRatePerMonth)  {
        super(mobileCompany, mobileName);
        this.leaseRatePerMonth = leaseRatePerMonth;
    }



}
