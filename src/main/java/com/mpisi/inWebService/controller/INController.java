package com.mpisi.inWebService.controller;

import com.mpisi.inWebService.entitys.Subscriber;
import com.mpisi.inWebService.services.INService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/in")
public class INController {
    @Autowired
    private INService inService;

    @PostMapping("/newconnection")
    public ResponseEntity<String> newConnection(@RequestParam String number) {
        inService.newConnection(number);
        return ResponseEntity.ok("Nouvelle connexion enregistrée avec succès sur l'IN");
    }

    @PostMapping("/termination")
    public ResponseEntity<String> termination(@RequestParam String number) {
        inService.termination(number);
        return ResponseEntity.ok("Termination effectuée avec succès sur l'IN");
    }

    @GetMapping("/query/{number}")
    public ResponseEntity<Subscriber> query(@PathVariable String number) {
        Subscriber subscriber = inService.query(number);
        return ResponseEntity.ok(subscriber);
    }
}
