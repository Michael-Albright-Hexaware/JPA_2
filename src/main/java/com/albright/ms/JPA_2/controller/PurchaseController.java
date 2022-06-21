//package com.albright.ms.JPA_2.controller;
//
//import com.albright.ms.JPA_2.entity.Lease;
//import com.albright.ms.JPA_2.entity.Purchase;
//import com.albright.ms.JPA_2.service.LeaseService;
//import com.albright.ms.JPA_2.service.PurchaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class PurchaseController {
//
//    @Autowired
//    PurchaseService purchaseService;
//
//    @PostMapping("/mobile/purchase")
//    public ResponseEntity<Purchase> createNewPurchase(@RequestBody Purchase purchase) {
//        return purchaseService.createNewPurchase(purchase);
//    }
//}
