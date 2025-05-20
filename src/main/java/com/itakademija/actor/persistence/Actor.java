package com.itakademija.actor.persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", Actor.class.getSimpleName() + "[", "]")
                .add("actorId=" + actorId)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("lastUpdate=" + lastUpdate)
                .toString();
    }
}
