package com.albright.ms.JPA_2.serviceImpl;

import com.albright.ms.JPA_2.entity.App;
import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.repository.AppRepository;
import com.albright.ms.JPA_2.repository.MobileRepository;
import com.albright.ms.JPA_2.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    AppRepository appRepository;
    @Override
    public ResponseEntity<App> addNewApp(App app) {
        try {
            App newApp = appRepository.save(new App(app.getAppName()));
            return new ResponseEntity<>(newApp, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<App>> getAllApps() {
        try {
            List<App> allApps = appRepository.findAll();
            if(allApps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(allApps, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
