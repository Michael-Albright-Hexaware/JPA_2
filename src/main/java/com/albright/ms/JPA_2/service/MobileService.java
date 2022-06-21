package com.albright.ms.JPA_2.service;

import com.albright.ms.JPA_2.entity.Lease;
import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.entity.Purchase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface MobileService {
    ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile);

    ResponseEntity<List<Mobile>> getAllMobiles();

    ResponseEntity<HashMap<String, List<String>>> showMobilesAndTheirApps();


    ResponseEntity<HashMap<String, List<String>>> showMobileNameAndAppsByCompany(@RequestParam String mobileCompany);

    ResponseEntity<Lease> addNewLeasedMobile(@RequestBody Lease lease);

    ResponseEntity<Purchase> addNewPurchasedMobile(@RequestBody Purchase purchase);

    ResponseEntity<Mobile> addMobileSpecs(@PathVariable Long mobileId, @RequestParam int memoryAmtInGigs, @RequestParam boolean hotSpot);
}
