package bozlak.autowiredless.dataAccess.concretes.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

// import javax.persistence.EntityManager;

// import org.hibernate.Session;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import bozlak.autowiredless.dataAccess.abstracts.UsStateDal;
import bozlak.autowiredless.entities.UsState;

@Repository
public class HibernateUsStateDal implements UsStateDal {

    // @Autowired
    // private EntityManager entityManager;

    // public HibernateUsStateDal(EntityManager entityManager) {
    //     this.entityManager = entityManager;
    // }

    Session session
    = new Configuration().configure("hibernate.cfg.xml")
    .addAnnotatedClass(UsState.class).buildSessionFactory().openSession();

    @Override
    // @Transactional
    public List<UsState> getAll() {
        // Session session = entityManager.unwrap(Session.class);

        // List<UsState> usStates 
        // = session.createQuery("from UsState",UsState.class).getResultList();
        // return usStates;

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
