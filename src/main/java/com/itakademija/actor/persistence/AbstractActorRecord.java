package com.itakademija.actor.persistence;

import com.itakademija.AbstractActiveRecord;

public abstract class AbstractActorRecord extends AbstractActiveRecord<AbstractActorRecord> {

    public Actor getThis(){
        return (Actor) this;
    }

    public Actor save(){
        return executeInTransaction(session -> {
            Integer id = (Integer) session.save(getThis());
            getThis().setActorId(id);
            return getThis();
        });
    }
}
