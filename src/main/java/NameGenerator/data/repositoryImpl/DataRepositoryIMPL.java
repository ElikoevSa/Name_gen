package NameGenerator.data.repositoryImpl;

import NameGenerator.config.HibernateUtils;
import NameGenerator.data.repository.DataRepository;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import java.util.ArrayList;
import java.util.List;

public class DataRepositoryIMPL implements DataRepository<Object> {

  StatelessSession session = HibernateUtils.getSession().openStatelessSession();

    @Override
    public void save(Object o) {
                session.getTransaction().begin();
                session.insert(o);
        session.getTransaction().commit();
                session.close();
    }

    @Override
    public void saveAll(List<Object> list) throws HibernateException,IllegalArgumentException {
        try {
            session.getTransaction().begin();
            for (Object o:list){
                session.insert(o);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object> findAll(Class o) throws IllegalArgumentException,HibernateException{
    try {
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.<Object>createQuery(o);
        Root<Object> rootEntry = cq.from(o);
        CriteriaQuery<Object> all = cq.select(rootEntry);
        TypedQuery<Object> allQuery = session.createQuery(all);


        return allQuery.getResultList().stream().toList();
    }
    catch (Exception e) {throw new HibernateException(e);}
    }

    @Override
    public void findOneById(Object o) {
        session.getTransaction().begin();
        session.get(o.getClass(),o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Object o) {
        session.getTransaction().begin();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Object o) {
            session.getTransaction().begin();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
    }
}
