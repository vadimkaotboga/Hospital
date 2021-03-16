package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Doctor;

import java.util.List;

public class DoctorDaoImpl implements DAO<Doctor, Integer> {

    SessionFactory factory;

    public DoctorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Doctor doctor) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Doctor doctor) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(doctor);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        }
    }

    @Override
    public Doctor findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Doctor.class, id);
        }
    }

    @Override
    public List<Doctor> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Doctors", Doctor.class).list();
        }
    }
}
