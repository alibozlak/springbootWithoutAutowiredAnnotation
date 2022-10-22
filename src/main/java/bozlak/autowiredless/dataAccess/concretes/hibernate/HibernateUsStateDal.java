package bozlak.autowiredless.dataAccess.concretes.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Repository;

import bozlak.autowiredless.dataAccess.abstracts.UsStateDal;
import bozlak.autowiredless.entities.UsState;

@Repository
public class HibernateUsStateDal implements UsStateDal {

    Session session;

    @Override
    public List<UsState> getAll() {
        session = this.getSession();

        List<UsState> usStates = null;
        try {
            session.beginTransaction();

            usStates = session.createQuery("from UsState", UsState.class)
            .getResultList();

            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return usStates;
    }

    @Override
    public UsState getById(int stateId) {
        Transaction transaction = null;
        UsState usState = null;
        try (Session session = getSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            usState = session
            .createQuery("from UsState where stateId=" + stateId + "", UsState.class)
            .getSingleResult();

            // commit transaction
            transaction.commit();
            return usState;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    private Session getSession() {
        return new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(UsState.class).buildSessionFactory().openSession();
    }
    
}
