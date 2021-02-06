//package com.jung.util;
//
//import com.jung.commons.SessionNames;
//import com.jung.entity.MemberVo;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionNames {
//
////    @Override
////    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
////        HttpSession httpSession = request.getSession();
////
////        if (httpSession.getAttribute(LOGIN) != null) {
////            httpSession.removeAttribute(LOGIN);
////        }
////
////        return true;
////    }
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        MemberVo loginVo = (MemberVo) session.getAttribute("loginVo");
//
//        if (loginVo == null) {
//            response.sendRedirect("/membership/login");
//            return false;
//        }
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        super.afterCompletion(request, response, handler, ex);
//    }
//}
