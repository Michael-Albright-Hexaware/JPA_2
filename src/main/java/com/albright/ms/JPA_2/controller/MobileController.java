package com.albright.ms.JPA_2.controller;

import com.albright.ms.JPA_2.entity.Lease;
import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.entity.Purchase;
import com.albright.ms.JPA_2.service.MobileService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;

@RestController
public class MobileController {

    @Autowired
    MobileService mobileService;

    @PostMapping("/mobile")
    public ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile) {
        return mobileService.addNewMobile(mobile);
    }

    @GetMapping("/mobiles")
    public ResponseEntity<List<Mobile>> getAllMobiles() {
        return mobileService.getAllMobiles();
    }

    @GetMapping("/mobile/app")
    public ResponseEntity<HashMap<String, List<String>>> showMobilesAndTheirApps() {
        return mobileService.showMobilesAndTheirApps();
    }

    @GetMapping("/mobile")
    public ResponseEntity<HashMap<String, List<String>>> showMobileNameAndAppsByCompany(@RequestParam String mobileCompany) {
        return mobileService.showMobileNameAndAppsByCompany(mobileCompany);
    }

    @PostMapping("/mobile/lease")
    public ResponseEntity<Lease> addNewLeasedMobile(@RequestBody Lease lease) {
        return mobileService.addNewLeasedMobile(lease);
    }

    @PostMapping("/mobile/purchase")
    public ResponseEntity<Purchase> addNewPurchasedMobile(@RequestBody Purchase purchase) {
        return mobileService.addNewPurchasedMobile(purchase);
    }

}
