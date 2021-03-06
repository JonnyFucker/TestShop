package shop.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tomek on 2016-10-03.
 */
public class CategoryTest {
    @Test
    public void getCategoryListTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/");

        CategoryDAOImpl categoryDAO = (CategoryDAOImpl) applicationContext.getBean("userDao");
        Assert.assertEquals(16,categoryDAO.getCategoryEntities().size());
    }
}
