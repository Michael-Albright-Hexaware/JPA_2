package com.albright.ms.JPA_2.controller;

import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobileController {

    @Autowired
    MobileService mobileService;

    @PostMapping("/mobile")
    public ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile) {
        return mobileService.addNewMobile(mobile);
    }

    @PutMapping("/mobile/{mobileId}/app/{appId}")
    public ResponseEntity<Mobile> addAppToMobile(@PathVariable Long mobileId, @PathVariable Long appId) {
        return mobileService.addAppToMobile(mobileId, appId);
    }

    @GetMapping("/mobile")
    public ResponseEntity<List<Mobile>> getAllMobiles() {
        return mobileService.getAllMobiles();
    }
}
