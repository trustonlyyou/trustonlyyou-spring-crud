package com.crowdfunding.util;

import com.crowdfunding.member.entity.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        if (session.getAttribute("userInfo") != null) {
            session.removeAttribute("userInfo");
        }

        return true;
    }

    // After Controller
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

//        HttpSession session = request.getSession();
//        MemberVo userInfo = (MemberVo) session.getAttribute("userInfo");

//        if (userInfo == null) {
//            logger.info("Session is null");
//            // TODO: 2021-02-10 model 객체 어떻게 넘길래?
//            response.sendRedirect("/membership/login");
//        } else {
//            logger.info("User Session :: '{}'", userInfo.getUserId());
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
