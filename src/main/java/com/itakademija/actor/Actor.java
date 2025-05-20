package com.itakademija.actor;

import java.io.Serializable;
import java.sql.Timestamp;

public class Actor implements Serializable {
    private Integer actorId;
    private String firstName;
    private  String lastName;
    private Timestamp lastUpdate;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Timestamp lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
