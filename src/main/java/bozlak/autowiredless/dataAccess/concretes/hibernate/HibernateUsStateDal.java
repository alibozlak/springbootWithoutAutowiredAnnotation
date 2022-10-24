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

    @Override
    public List<UsState> getAll() {
        Session session = this.getSession();

        List<UsState> usStates = null;
        try {
            session.beginTransaction();

            String hql = "from UsState order by stateId";
            usStates = session.createQuery(hql, UsState.class)
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
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();

            // String hql = "from UsState us where us.stateId=" + stateId;
            // usState = session.createQuery(hql, UsState.class).uniqueResult();

            usState = session.get(UsState.class,stateId);

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

    @Override
    public void add(UsState usState) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.save(usState);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(UsState usState) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.update(usState);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(UsState usState) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.delete(usState);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
