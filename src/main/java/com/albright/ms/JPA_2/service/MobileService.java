package com.albright.ms.JPA_2.service;

import com.albright.ms.JPA_2.entity.Mobile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MobileService {
    ResponseEntity<Mobile> addNewMobile(@RequestBody Mobile mobile);

    ResponseEntity<Mobile> addAppToMobile(@PathVariable Long mobileId, @PathVariable Long appId);

    ResponseEntity<List<Mobile>> getAllMobiles();

}
