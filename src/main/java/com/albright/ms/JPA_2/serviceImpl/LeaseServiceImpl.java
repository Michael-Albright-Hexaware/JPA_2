//package com.albright.ms.JPA_2.serviceImpl;
//
//import com.albright.ms.JPA_2.entity.Lease;
//import com.albright.ms.JPA_2.repository.LeaseRepository;
//import com.albright.ms.JPA_2.service.LeaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LeaseServiceImpl implements LeaseService {
//    @Autowired
//    LeaseRepository leaseRepository;
//    @Override
//    public ResponseEntity<Lease> createNewLease(Lease lease) {
//        try {
//            Lease newLease = leaseRepository.save(new Lease(lease.getMobileCompany(), lease.getMobileName(), lease.getLeaseRatePerMonth()));
//            return new ResponseEntity<>(newLease, HttpStatus.OK);
//        } catch(Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
