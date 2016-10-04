package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.CategoryDAO;
import shop.dao.FilmDAO;
import shop.entities.CategoryEntity;
import shop.entities.FilmEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-10-04.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private FilmDAO filmDAO;

    @RequestMapping(value = "/category")
    public List<CategoryEntity> categories() {
        return categoryDAO.getCategoryEntities();
    }

    @RequestMapping(value = "/category/{id}")
    public List<FilmEntity> films(@PathVariable("id") int id) {
        return filmDAO.getFilmsByCategoryId(id);
    }
}
