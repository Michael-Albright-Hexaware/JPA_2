package com.albright.ms.JPA_2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase extends Mobile {

    private BigDecimal purchasedPrice;

    public Purchase(String mobileCompany, String mobileName, BigDecimal purchasedPrice) {
        super(mobileCompany, mobileName);
        this.purchasedPrice = purchasedPrice;
    }
}
