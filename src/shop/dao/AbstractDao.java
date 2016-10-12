package shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tomek on 2016-10-12.
 */
public abstract class AbstractDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void persist(Object entity){
        getSession().persist(entity);
    }
    public void delete(Object entity){
        getSession().delete(entity);
    }
}
