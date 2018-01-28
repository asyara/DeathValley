package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Service;

/**
 * Created by DmitryL on 28.01.2018.
 */
@Controller
public class ServletController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/richest", method = RequestMethod.POST)
    public String getRichestUser(ModelMap model) {
        Service srv = new Service();
        model.addAttribute("richestUser", srv.getRichestUser().getName() + " " + srv.getRichestUser().getSureName());
        return "index";
    }

    @RequestMapping(value = "/sum", method = RequestMethod.POST)
    public String getSum(ModelMap model) {
        Service srv = new Service();
        model.addAttribute("sum", srv.getAccountsSum());
        return "index";
    }
}
