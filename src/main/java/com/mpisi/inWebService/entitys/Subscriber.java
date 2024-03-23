package com.mpisi.inWebService.entitys;

import com.mpisi.inWebService.enumerations.SubscriberType;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private String imsi;

    @Enumerated(EnumType.STRING)
    private SubscriberType subscriberType;

    private boolean isNewConnection;

    private Date creationDate;

    // Informations spécifiques à la plateforme IN
    private int rechargeData;
    private int rechargeAppel;
    private int rechargeSMS;

    // Liste des services actifs
    @ElementCollection
    private List<String> activeServices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public SubscriberType getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(SubscriberType subscriberType) {
        this.subscriberType = subscriberType;
    }

    public List<String> getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(List<String> activeServices) {
        this.activeServices = activeServices;
    }

    public boolean isNewConnection() {
        return isNewConnection;
    }

    public void setNewConnection(boolean newConnection) {
        isNewConnection = newConnection;
    }

    public int getRechargeData() {
        return rechargeData;
    }

    public void setRechargeData(int rechargeData) {
        this.rechargeData = rechargeData;
    }

    public int getRechargeAppel() {
        return rechargeAppel;
    }

    public void setRechargeAppel(int rechargeAppel) {
        this.rechargeAppel = rechargeAppel;
    }

    public int getRechargeSMS() {
        return rechargeSMS;
    }

    public void setRechargeSMS(int rechargeSMS) {
        this.rechargeSMS = rechargeSMS;
    }
}

