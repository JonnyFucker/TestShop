package shop.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tomek on 2016-10-03.
 */
public class CategoryTest {
    @Test
    public void getCategoryListTest(){
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        Assert.assertEquals(16,categoryDAO.getCategoryEntities().size());
    }
}
