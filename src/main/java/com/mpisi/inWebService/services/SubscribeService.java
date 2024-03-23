package com.mpisi.inWebService.services;

import com.mpisi.inWebService.entitys.Subscriber;
import com.mpisi.inWebService.enumerations.SubscriberType;
import com.mpisi.inWebService.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Service
public class SubscribeService {
    @Autowired
    private SubscriberRepository subscriberRepository;

    public void createSubscribe(String number, SubscriberType subscriberType) {
        // Logique pour activer un abonné dans le HLR
        Subscriber subscriber = new Subscriber();
        subscriber.setNumber(number);
        subscriber.setImsi(generateImsi());  // Méthode à implémenter pour générer un IMSI unique
        subscriber.setCreationDate(new Date());
        subscriber.setSubscriberType(subscriberType);
        subscriber.setNewConnection(true);

        // Ajoutez les services par défaut
        //subscriber.setActiveServices(Arrays.asList(Services.SERV_VOICE.name(), Services.SERV_SMS.name()));


        subscriberRepository.save(subscriber);
    }

    // Méthode pour générer un IMSI unique (à adapter selon vos besoins)
    private String generateImsi() {
        return UUID.randomUUID().toString();
    }

}
