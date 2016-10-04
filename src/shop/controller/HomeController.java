package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dao.CategoryDAO;

/**
 * Created by Tomek on 2016-10-02.
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/")
    public String any() {
        return "index";
    }

    @RequestMapping(value = "/nav")
    public String navbar() {
        return "nav";
    }

    @RequestMapping(value = "/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "checkout";

    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/confirmation")
    public String confirmation() {
        return "confirmation";
    }

/*    @RequestMapping(value = "/base")
    public String database() {
        System.out.println("SIZE : " + categoryDAO.getCategoryEntities().size());

        return "testDataBase";
    }*/

}
