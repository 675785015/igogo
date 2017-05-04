package com.igogo.portal.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee on 2017/5/4.
 */
@Controller
public class CommonController extends BaseController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("index", "xia");
        return "index";
    }

    @RequestMapping("/page1")
    public String page1(Model model){
        request.setAttribute("name", "xia");
        return "page1";
    }

    @RequestMapping("/page2")
    public String page2(Model model){
        String name = (String) request.getAttribute("name");
        model.addAttribute("name", name);
        return "page2";
    }
}
