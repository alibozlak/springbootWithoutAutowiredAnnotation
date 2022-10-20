package bozlak.autowiredless.dataAccess.concretes.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Repository;

import bozlak.autowiredless.dataAccess.abstracts.UsStateDal;
import bozlak.autowiredless.entities.UsState;

@Repository
public class HibernateUsStateDal implements UsStateDal {

    Session session
    = new Configuration().configure("hibernate.cfg.xml")
    .addAnnotatedClass(UsState.class).buildSessionFactory().openSession();

    @Override
    public List<UsState> getAll() {
        List<UsState> usStates = null;

        try {
            session.beginTransaction();
            usStates = session.createQuery("from UsState").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        
        return usStates;
    }
    
}
