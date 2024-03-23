package com.mpisi.inWebService.controller;

import com.mpisi.inWebService.enumerations.SubscriberType;
import com.mpisi.inWebService.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/in")
public class SubscriberController {

    @Autowired
    SubscribeService subscribeService;
    @PostMapping("/createSubs")
    public ResponseEntity<String> activateSubscriber(
            @RequestParam String number,
            @RequestParam SubscriberType subscriberType) {
        subscribeService.createSubscribe(number, subscriberType);
        return ResponseEntity.status(HttpStatus.CREATED).body("Abonné activé avec succès dans le HLR");
    }
}
