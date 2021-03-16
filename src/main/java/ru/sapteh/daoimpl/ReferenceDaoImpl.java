package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Reference;

import java.util.List;

public class ReferenceDaoImpl implements DAO<Reference, Integer> {

    SessionFactory factory;

    public ReferenceDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Reference reference) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(reference);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Reference reference) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(reference);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Reference reference) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(reference);
            session.getTransaction().commit();
        }
    }

    @Override
    public Reference findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Reference.class, id);
        }
    }

    @Override
    public List<Reference> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM References", Reference.class).list();
        }
    }
}
