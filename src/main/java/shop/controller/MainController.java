package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import shop.cart.ShoppingCart;
import shop.dao.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tomek on 2016-10-02.
 */
@Controller
public class MainController implements ServletContextAware {

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
    public String confirmation(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getAttribute("orderId"));

        return "confirmation";
    }


    @RequestMapping(value = "/base")
    public String database() {

        return "testDataBase";
    }

}
