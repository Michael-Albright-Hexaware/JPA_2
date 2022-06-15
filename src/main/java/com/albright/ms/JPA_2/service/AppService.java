package com.albright.ms.JPA_2.service;

import com.albright.ms.JPA_2.entity.App;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AppService {
    ResponseEntity<App> addNewApp(@RequestBody App app);

    ResponseEntity<List<App>> getAllApps();

}
