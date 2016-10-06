package shop.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import shop.entities.FilmEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-10-04.
 */
public class FilmDAOImpl implements FilmDAO {

    private Session session = null;
    private SessionFactory sessionFactory;

    @Autowired
    public FilmDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public FilmEntity getFilmById(int id) {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FilmEntity film where film.filmId=" + id);
        FilmEntity filmEntity = (FilmEntity) query.uniqueResult();
        return filmEntity;
    }

    @Override
    @Transactional
    public List<FilmEntity> getFilmsByCategoryId(int id) {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select fc.filmByFilmId from FilmCategoryEntity fc " +
                "where fc.categoryId=" + id);
        List<FilmEntity> filmEntities = query.list();
        return filmEntities;
    }
}
