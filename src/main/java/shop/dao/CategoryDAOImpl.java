package shop.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import shop.entities.CategoryEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-10-03.
 */

public class CategoryDAOImpl implements CategoryDAO {
    private Session session = null;
    private SessionFactory sessionFactory;

    public CategoryDAOImpl() {
    }

    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<CategoryEntity> getCategoryEntities() {
        List<CategoryEntity> categoryEntityList = null;

        try {
            //Transaction transaction = session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from CategoryEntity ");
            categoryEntityList = (List<CategoryEntity>) query.list();
            //transaction.commit();

        } catch (Exception e) {
            // session.getTransaction().rollback();
            e.printStackTrace();

        }
        return categoryEntityList;

    }
}
