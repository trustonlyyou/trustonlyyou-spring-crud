package com.crowdfunding.member.controller;

import com.crowdfunding.member.service.MembershipService;
import com.crowdfunding.util.EncryptionSHA256;
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
    public String FindPassword(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        Map<String, Object> userInfo = new HashMap<>();

        String userName = request.getParameter("userName");
        String userId = request.getParameter("userId");
        String userPhone = request.getParameter("userPhone");

        try {
            if((userName == null || "".equals(userName)) || (userId == null || "".equals(userId)) || (userPhone == null || "".equals(userPhone))) {
                model.addAttribute("msg", "사용자의 정보를 옳바르게 입력해 주세요.");
                return "/membership/findPassword";
            }

            userInfo.put("userName", userName);
            userInfo.put("userId", userId);
            userInfo.put("userPhone", userPhone);

            Integer check = service.isUserPassword(userInfo);

            if(check == 0) {
                model.addAttribute("msg", "입력하신 정보의 회원이 없습니다.");
                return "/membership/findPassword";
            }

//            model.addAttribute("userPhone", userPhone); // 해당 객체 안넘어간다.
            session.setAttribute("userPhone", userPhone);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return "/membership/modifyPassword";
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword() {
        return "/membership/modifyPassword";
    }

    @PostMapping("/postModifyPassword")
    public String modifyPassword(HttpServletRequest request, Model model, HttpSession session) {

        Map<String, Object> userInfo = new HashMap<>();

        try {
//            String userPhone = (String) model.getAttribute("userPhone");
            String userPhone = (String) session.getAttribute("userPhone");
            String newUserPassword = request.getParameter("newUserPassword");

            if ((userPhone == null) || "".equals(userPhone) || (newUserPassword == null  || "".equals(newUserPassword))) {
                logger.info("User Info Null or Empty");
                model.addAttribute("msg", "옳바르게 입력해 주세요.");
                return "/membership/modifyPassword";
            }

            session.invalidate();
            String newUserPasswordEncryption = EncryptionSHA256.encrypt(newUserPassword);

            logger.info("userPhone :: '{}'", userPhone);
            logger.info("newUserPassword :: '{}'", newUserPassword);

            userInfo.put("userPhone", userPhone);
            userInfo.put("newUserPassword", newUserPasswordEncryption);

            service.changeUserPassword(userInfo);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/membership/modifyPasswordSuccess";
    }

    @GetMapping("modifyPasswordSuccess")
    public String modifyPasswordSuccess() {
        return "/membership/modifyPasswordSuccess";
    }
}
