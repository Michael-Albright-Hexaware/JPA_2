//package com.albright.ms.JPA_2.serviceImpl;
//
//import com.albright.ms.JPA_2.entity.Purchase;
//import com.albright.ms.JPA_2.repository.PurchaseRepository;
//import com.albright.ms.JPA_2.service.PurchaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PurchaseServiceImpl implements PurchaseService {
//
//    @Autowired
//    PurchaseRepository purchaseRepository;
//
//    @Override
//    public ResponseEntity<Purchase> createNewPurchase(Purchase purchase) {
//        try {
//            Purchase newPurchase = purchaseRepository.save(
//                    new Purchase(purchase.getMobileCompany(), purchase.getMobileName(), purchase.getPrice()));
//            return new ResponseEntity<>(newPurchase, HttpStatus.OK);
//        } catch(Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
