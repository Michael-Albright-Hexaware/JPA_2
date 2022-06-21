//package com.albright.ms.JPA_2.controller;
//
//import com.albright.ms.JPA_2.entity.Lease;
//import com.albright.ms.JPA_2.entity.Mobile;
//import com.albright.ms.JPA_2.service.LeaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LeaseController {
//
//    @Autowired
//    LeaseService leaseService;
//
//    @PostMapping("/mobile/lease")
//    public ResponseEntity<Lease> createNewLease(@RequestBody Lease lease) {
//        return leaseService.createNewLease(lease);
//    }
//}
