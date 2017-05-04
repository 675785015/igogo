package com.igogo.portal.common;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lee on 2017/5/4.
 */
public class BaseController {

    protected HttpServletResponse response;
    protected HttpServletRequest request;

    @ModelAttribute
    public void setHttpServlet(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }
}
