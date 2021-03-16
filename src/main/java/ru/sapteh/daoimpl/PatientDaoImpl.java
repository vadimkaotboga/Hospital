package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Patient;

import java.util.List;

public class PatientDaoImpl implements DAO<Patient, Integer> {

    SessionFactory factory;

    public PatientDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Patient patient) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Patient patient) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(patient);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Patient patient) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
        }
    }

    @Override
    public Patient findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Patient.class, id);
        }
    }

    @Override
    public List<Patient> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Patients", Patient.class).list();
        }
    }
}
