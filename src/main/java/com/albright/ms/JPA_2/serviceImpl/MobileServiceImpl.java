package com.albright.ms.JPA_2.serviceImpl;

import com.albright.ms.JPA_2.entity.*;
import com.albright.ms.JPA_2.repository.AppRepository;
import com.albright.ms.JPA_2.repository.MobileRepository;
import com.albright.ms.JPA_2.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.HashMap;
import java.util.List;


@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    MobileRepository mobileRepository;

    @Autowired
    AppRepository appRepository;

    private HashMap<String, List<String>> getAppsFromMobile(List<Mobile> mobileList) {
        HashMap<String, List<String>> hash = new HashMap<>();
        mobileList .forEach(mobile -> {
            List<String> appNames = mobile.getApps()
                    .stream()
                    .map(App::getAppName)
                    .toList();
            hash.put(mobile.getMobileName(), appNames);
        });
        return hash;
    }

            //  NEW MOBILE
//    @Override
//    public ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile) {
//        try {
//            Mobile newMobile = mobileRepository.save(new Mobile(mobile.getMobileCompany(), mobile.getMobileName()));
//            return new ResponseEntity<>(newMobile, HttpStatus.OK);
//        } catch(Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

                    // GET ALL MOBILES
    @Override
    public ResponseEntity<List<Mobile>> getAllMobiles() {
        try {
            List<Mobile> allMobiles = mobileRepository.findAll();
            if(allMobiles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(allMobiles, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
                    //QUERY 1: GET MOBILE NAMES AND THEIR APP NAMES
    @Override
    public ResponseEntity<HashMap<String, List<String>>> showMobilesAndTheirApps() {
        //get mobiles, retrieve mobileName and appName
        try {
            List<Mobile> allMobiles = mobileRepository.findAll();
            HashMap<String, List<String>> newHash = getAppsFromMobile(allMobiles);
            return new ResponseEntity<>(newHash, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HashMap<String, List<String>>> showMobileNameAndAppsByCompany(@RequestParam String mobileCompany) {
        // find mobile by company name, return the name of the phone and the apps on it
        try {
            List<Mobile> mobilesByCompany = mobileRepository.findAll()
                    .stream()
                    .filter(m -> m.getMobileCompany().equals(mobileCompany))
                    .toList();
            HashMap<String, List<String>> newHash = getAppsFromMobile(mobilesByCompany);
            return new ResponseEntity<>(newHash, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Lease> addNewLeasedMobile(@RequestBody Lease lease) {
        try {
            Lease newLease = mobileRepository.save(new Lease(lease.getMobileCompany(), lease.getMobileName(), lease.getLeaseRatePerMonth(), lease.getMobileSpecs()));

            //create URI
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newLease.getId()).toUri();

            new ResponseEntity<>(newLease, HttpStatus.CREATED);
            return ResponseEntity.created(location).build();
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Purchase> addNewPurchasedMobile(@RequestBody Purchase purchase) {
        try {
            Purchase newPurchase = mobileRepository.save(new Purchase(purchase.getMobileCompany(), purchase.getMobileName(), purchase.getPurchasedPrice(), purchase.getMobileSpecs()));
            return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Mobile> addMobileSpecs(@PathVariable Long mobileId, @RequestParam int memoryAmtInGigs, @RequestParam boolean hotSpot) {
        try {
            if(mobileRepository.findById(mobileId).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Mobile updateMobile = mobileRepository.findById(mobileId).get();
            try {
                updateMobile.setMobileSpecs(new MobileSpecs(memoryAmtInGigs, hotSpot));
            } catch(Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            mobileRepository.save(updateMobile);
            return new ResponseEntity<>(updateMobile, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
