package com.mpisi.inWebService.services;

import com.mpisi.inWebService.entitys.Subscriber;
import com.mpisi.inWebService.enumerations.SubscriberType;
import com.mpisi.inWebService.repository.INRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class INService {
    @Autowired
    private INRepository inRepository;

    public void newConnection(String number) {
        // Logique pour enregistrer un abonné PREPAID sur l'IN et gérer sa consommation automatiquement

        Subscriber subscriber = inRepository.findByNumberAndSubscriberType(number, SubscriberType.PREPAID)
                .orElseThrow(() -> new EntityNotFoundException("Abonné PREPAID non trouvé avec le numéro : " + number));
        // Logique pour gérer la nouvelle connexion sur l'IN
        // Par exemple, initialiser les informations de consommation, etc.
        subscriber.setNewConnection(true);
        subscriber.setRechargeAppel(0);
        subscriber.setRechargeData(0);
        subscriber.setRechargeSMS(0);
        // Autres opérations spécifiques à la nouvelle connexion sur l'IN

        inRepository.save(subscriber);
    }

    public void termination(String number) {
        // Logique pour supprimer un abonné PREPAID sur l'IN
        Subscriber subscriber = inRepository.findByNumberAndSubscriberType(number, SubscriberType.PREPAID)
                .orElseThrow(() -> new EntityNotFoundException("Abonné PREPAID non trouvé avec le numéro : " + number));

        // Logique pour gérer la résiliation sur l'IN
        // Par exemple, libérer les ressources, désactiver les services, etc.

        inRepository.delete(subscriber);
    }

    public Subscriber query(String number) {
        // Récupérer toutes les informations d'un abonné PREPAID sur l'IN
        return inRepository.findByNumberAndSubscriberType(number, SubscriberType.PREPAID)
                .orElseThrow(() -> new EntityNotFoundException("Abonné PREPAID non trouvé avec le numéro : " + number));
    }
}
