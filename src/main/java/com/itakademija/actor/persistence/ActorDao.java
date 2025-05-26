package com.itakademija.actor.persistence;

import com.itakademija.Dao;

import java.util.List;

public class ActorDao implements Dao<Actor, Integer> {
    @Override
    public List<Actor> getAll() {
        return executeInTransaction(session -> session.createQuery("from Actor").list());
    }

    @Override
    public Actor getById(Integer id) {
        return executeInTransaction(session -> session.get(Actor.class, id));
    }

    @Override
    public Actor save(Actor actor) {
        return executeInTransaction(session -> {
            int id = (int) session.save(actor);
            actor.setActorId(id);
            return actor;
        });
    }

    @Override
    public void delete(Actor actor) {
        executeInTransaction(session -> {
            session.delete(actor);
            return actor.getActorId();
        });
    }

    @Override
    public void update(Actor actor) {
        executeInTransaction(session -> session.merge(actor));
    }
}
