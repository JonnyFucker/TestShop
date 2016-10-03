package shop.dao;

import shop.entities.CategoryEntity;

import java.util.List;

/**
 * Created by Tomek on 2016-10-03.
 */
public interface CategoryDAO {
    List<CategoryEntity> getCategoryEntities();
}
