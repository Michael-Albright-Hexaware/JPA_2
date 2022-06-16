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
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
    @Override
    public ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile) {
        try {
            Mobile newMobile = mobileRepository.save(new Mobile(mobile.getMobileCompany(), mobile.getMobileName()));
            return new ResponseEntity<>(newMobile, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
//            HashMap<String, List<String>> hash = new HashMap<>();
//            mobileRepository.findAll()
//                    .forEach(mobile -> {
//                        List<String> appNames = mobile.getApps()
//                                .stream()
//                                .map(App::getAppName)
//                                .toList();
//                        hash.put(mobile.getMobileName(), appNames);
//                    });
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


}
