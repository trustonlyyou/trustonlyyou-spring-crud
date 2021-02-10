package com.crowdfunding.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    // Before Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (session.getAttribute("result") != null) {
            session.removeAttribute("result");
        }

        return true;
    }

    // After Controller
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("result");

        logger.info("User Session :: '{}'", login);

        if (login != null) {
            logger.info("new login");
            response.sendRedirect("/");
        }

//        if (login == null) {
//            logger.info("여기서 리다이렉트");
//            response.sendRedirect("/membership/login");
//        } else {
//            response.sendRedirect("/");
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
////            dispatcher.forward(request, response);
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
