package id.co.roxas.efim.angularjsstyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class WebController {
   @RequestMapping(value="/index",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
}