package com.albright.ms.JPA_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable()
public class MobileSpecs {

    private int memoryAmtInGigs;
    private boolean hotSpot;

}
