package shop.dao;

import shop.entities.FilmEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-10-04.
 */
public interface FilmDAO {
    List<FilmEntity> getFilmsByCategoryId(int id);
}
