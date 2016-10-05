package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import shop.dao.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

/**
 * Created by Tomek on 2016-10-02.
 */
@Controller
public class HomeController implements ServletContextAware {

    private ServletContext servletContext;

    @PostConstruct
    public void init() {
        servletContext.setAttribute("cate", categoryDAO.getCategoryEntities());

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

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

    @RequestMapping(value = "/base")
    public String database() {

        return "testDataBase";
    }

}
