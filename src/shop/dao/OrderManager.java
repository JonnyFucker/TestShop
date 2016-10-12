package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tomek on 2016-10-12.
 */
public class OrderManager {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private FilmDAO filmDAO;

}
