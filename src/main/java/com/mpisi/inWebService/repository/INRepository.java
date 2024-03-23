package com.mpisi.inWebService.repository;

import com.mpisi.inWebService.entitys.Subscriber;
import com.mpisi.inWebService.enumerations.SubscriberType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INRepository extends JpaRepository<Subscriber, Long> {
    Optional<Subscriber> findByNumberAndSubscriberType(String number, SubscriberType subscriberType);
}
