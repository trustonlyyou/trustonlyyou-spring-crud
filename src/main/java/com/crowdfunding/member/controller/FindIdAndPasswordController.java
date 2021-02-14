package com.crowdfunding.member.controller;

import com.crowdfunding.member.service.MembershipService;
import com.crowdfunding.commons.util.EncryptionSHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/membership")
public class FindIdAndPasswordController {

    private static final Logger logger = LoggerFactory.getLogger(FindIdAndPasswordController.class);

    @Autowired
    MembershipService service;


    // Find ID
    @GetMapping("/findId")
    public String findId() {
        return "/membership/findId";
    }

    @PostMapping("/postfindId")
    public String findId(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws Exception {

        Map<String, Object> userInfo =  new HashMap<>();
        String userName = "";
        String userPhone = "";
        String userId = "";

        try {
            userName = request.getParameter("userName");
            userPhone = request.getParameter("userPhone");

            userInfo.put("userName", userName);
            userInfo.put("userPhone", userPhone);

            userId = service.findUserId(userInfo);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        if (userId == null || "".equals(userId)) {
            logger.info("Don't mach information");
            redirectAttributes.addFlashAttribute("result", "fail");
            return "redirect:/membership/findIdResult";
        }

        redirectAttributes.addFlashAttribute("result", userId);

        return "/membership/findIdResult";
    }

    @GetMapping("/findIdResult")
    public String findIdSuccess() {
        return "/membership/findIdResult";
    }


    // Find Password
    @GetMapping("/findPassword")
    public String findPassword() {
        return "/membership/findPassword";
    }

    @PostMapping("/postFindPassword")
    public String FindPassword(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {

        Map<String, String> userInfo = new HashMap<>();
        String userName = "";
        String userId = "";
        String userPhone = "";
        Integer check = 0;

        try {
            userName = request.getParameter("userName");
            userId = request.getParameter("userId");
            userPhone = request.getParameter("userPhone");

            userInfo.put("userName", userName);
            userInfo.put("userId", userId);
            userInfo.put("userPhone", userPhone);

            check = service.isUserPassword(userInfo);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        if (check == 0) {
            logger.info("No User Information");
            redirectAttributes.addFlashAttribute("result", "fail");
            return "redirect:/membership/findPasswordResult";
        }

        session.setAttribute("userInfo", userInfo);

        return "/membership/modifyPassword";
    }

    @GetMapping("/findPasswordResult")
    public String passwordResult() {
        return "/membership/findPasswordResult";
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword() {
        return "/membership/modifyPassword";
    }

    @PostMapping("/postModifyPassword")
    public String modifyPassword(HttpServletRequest request, Model model, HttpSession session) {

        Map<String, String> userInfo = new HashMap<>();
        String userName = "";
        String userId = "";
        String userPhone = "";
        String newUserPassword = "";

        try {

            userInfo = (Map<String, String>) session.getAttribute("userInfo");

            userName = userInfo.get("userName");
            userId = userInfo.get("userId");
            userPhone = userInfo.get("userPhone");

            if ((userName != null || !"".equals(userName)) || (userId != null || !"".equals(userId)) || (userPhone != null || !"".equals(userPhone))) {
                session.removeAttribute("userInfo");
            }

            String newUserPasswordEncryption = EncryptionSHA256.encrypt(newUserPassword);

            userInfo.put("userPhone", userPhone);
            userInfo.put("newUserPassword", newUserPasswordEncryption);

            service.changeUserPassword(userInfo);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        logger.info("User Password Modify Success");

        return "redirect:/membership/modifyPasswordSuccess";
    }

    @GetMapping("modifyPasswordSuccess")
    public String modifyPasswordSuccess() {
        return "/membership/modifyPasswordSuccess";
    }
}
