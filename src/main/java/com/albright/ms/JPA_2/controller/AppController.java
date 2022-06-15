package com.albright.ms.JPA_2.controller;

import com.albright.ms.JPA_2.entity.App;
import com.albright.ms.JPA_2.entity.Mobile;
import com.albright.ms.JPA_2.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @PostMapping("/app")
    public ResponseEntity<App> addNewApp(@RequestBody App app) {
        return appService.addNewApp(app);
    }

    @GetMapping("/app")
    public ResponseEntity<List<App>> getAllApps() {
        return appService.getAllApps();
    }

}
