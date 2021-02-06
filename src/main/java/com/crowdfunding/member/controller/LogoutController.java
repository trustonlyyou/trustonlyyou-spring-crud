//package com.crowdfunding.member.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.support.SessionStatus;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/membership")
//public class LogoutController {
//
//    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session, SessionStatus sessionStatus, Model model) {
//
////        if (session == null) {
////            model.addAttribute("msg", "")
////        }
//        session.invalidate();
////        sessionStatus.isComplete();
//        return "index";
//    }
//
//}
// TODO: 2021-01-30 LogOut || View 처리
