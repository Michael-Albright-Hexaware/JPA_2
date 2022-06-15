package com.albright.ms.JPA_2.serviceImpl;

import com.albright.ms.JPA_2.entity.App;
import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.repository.AppRepository;
import com.albright.ms.JPA_2.repository.MobileRepository;
import com.albright.ms.JPA_2.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    MobileRepository mobileRepository;

    @Autowired
    AppRepository appRepository;

    @Override
    public ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile) {
        try {
            Mobile newMobile = mobileRepository.save(new Mobile(mobile.getMobileCompany(), mobile.getMobileName()));
            return new ResponseEntity<>(newMobile, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Mobile> addAppToMobile(@PathVariable Long mobileId, @PathVariable Long appId) {
        try {
            if(appRepository.findById(appId).isEmpty() || mobileRepository.findById(mobileId).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            App app = appRepository.findById(appId).get();
            Mobile mobile = mobileRepository.findById(mobileId).get();
            mobile.addNewApp(app);
            mobileRepository.save(mobile);
            return new ResponseEntity<>(mobile, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
}
