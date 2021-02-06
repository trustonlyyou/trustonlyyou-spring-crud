package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.LoginVo;
import com.crowdfunding.member.entity.MemberVo;
import com.crowdfunding.member.service.MembershipService;
import com.crowdfunding.util.EncryptionSHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/membership")
//@SessionAttributes("loginId") // 좀더 추상화 된 방법
public class MembershipController {

    private static final Logger logger = LoggerFactory.getLogger(MembershipController.class);

    @Autowired
    MembershipService service;

    // 회원 가입
//    @GetMapping("/joinPage")
//    public String join() {
//        return "/membership/join";
//    }
//
//    @PostMapping("/joinPost")
//    public String joinPost(@ModelAttribute MemberVo memberVo, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, RedirectAttributes redirectAttributes) throws Exception {
//
//        try {
//            if (memberVo == null) {
//                logger.error(memberVo.toString());
//                model.addAttribute("chk", false);
//                return "/membership/join";
//            } else {
//                String encryptionPassword = EncryptionSHA256.encrypt(memberVo.getUserPassword());
//                memberVo.setUserPassword(encryptionPassword);
//                logger.info(memberVo.toString());
//                service.joinMembershipService(memberVo);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return "redirect:/membership/join_result";
//    }
//
//
//    @GetMapping("/join_result")
//    public String join_Result() {
//        return "membership/join_result";
//    }

    // 로그인
//    @GetMapping("/login")
//    public String login() {
//        logger.info("login GET....");
//        return "/membership/login";
//    }
//
//    @PostMapping("/loginPost")
//    public String loginPost(@ModelAttribute LoginVo loginVo, Model model, HttpSession session) throws Exception {
//
//        try {
//            String encryptionPassword = EncryptionSHA256.encrypt(loginVo.getUserPassword());
//            loginVo.setUserPassword(encryptionPassword);
//
//            LoginVo result = service.loginService(loginVo);
//
//            if (result == null) {
//                model.addAttribute("message", "Fail Login");
//                return "membership/login";
//            } else {
//                // low level
//                session.setAttribute("loginId", result.getUserId());
//                model.addAttribute("loginId", result.getUserId());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return "redirect:/membership/loginSuccess";
//    }
//
//    @GetMapping("/loginSuccess")
//    public String loginSuccess() {
//        return "/membership/loginSuccess";
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
//        sessionStatus.isComplete();
        return "index";
    }

//    @GetMapping("/findId")
//    public String findId() {
//        return "/membership/findId";
//    }
//
//    @PostMapping("/postfindId")
//    public String findId(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws Exception {
//        Map<String, Object> userInfo =  new HashMap<>();
//
//        try {
//            String userName = request.getParameter("userName");
//            String userPhone = request.getParameter("userPhone");
//
//            if((userName == null || "".equals(userName)) || (userPhone == null || "".equals(userPhone))) {
//                model.addAttribute("msg", "이름과 핸드폰 번호를 옳바르게 입력해 주세요.");
//                return "membership/findId";
//            }
//
//            userInfo.put("userName", userName);
//            userInfo.put("userPhone", userPhone);
//
//            String userId = service.findUserId(userInfo);
//
//            if (userId == null || "".equals(userId)) {
//                model.addAttribute("msg", "입력하신 정보의 회원이 없습니다.");
//                return "/membership/findId";
//            }
//
//            redirectAttributes.addFlashAttribute("result", userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return "redirect:/membership/findIdSuccess";
//    }

//    @GetMapping("/findIdSuccess")
//    public String findIdSuccess() {
//        return "/membership/findIdSuccess";
//    }

//    @GetMapping("/findPassword")
//    public String findPassword() {
//        return "/membership/findPassword";
//    }
//
//    @PostMapping("/postFindPassword")
//    public String FindPassword(HttpServletRequest request, Model model, HttpSession session) throws Exception {
//        Map<String, Object> userInfo = new HashMap<>();
//
//        String userName = request.getParameter("userName");
//        String userId = request.getParameter("userId");
//        String userPhone = request.getParameter("userPhone");
//
//        try {
//            if((userName == null || "".equals(userName)) || (userId == null || "".equals(userId)) || (userPhone == null || "".equals(userPhone))) {
//                model.addAttribute("msg", "사용자의 정보를 옳바르게 입력해 주세요.");
//                return "/membership/findPassword";
//            }
//
//            userInfo.put("userName", userName);
//            userInfo.put("userId", userId);
//            userInfo.put("userPhone", userPhone);
//
//            Integer check = service.isUserPassword(userInfo);
//
//            if(check == 0) {
//                model.addAttribute("msg", "입력하신 정보의 회원이 없습니다.");
//                return "/membership/findPassword";
//            }
//
////            model.addAttribute("userPhone", userPhone); // 해당 객체 안넘어간다.
//            session.setAttribute("userPhone", userPhone);
//
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return "/membership/modifyPassword";
//    }
//
//    @GetMapping("/modifyPassword")
//    public String modifyPassword() {
//        return "/membership/modifyPassword";
//    }
//
//    @PostMapping("/postModifyPassword")
//    public String modifyPassword(HttpServletRequest request, Model model, HttpSession session) {
//
//        Map<String, Object> userInfo = new HashMap<>();
//
//        try {
////            String userPhone = (String) model.getAttribute("userPhone");
//            String userPhone = (String) session.getAttribute("userPhone");
//            String newUserPassword = request.getParameter("newUserPassword");
//
//            logger.info("userPhone :: '{}'" , userPhone);
//            logger.info("newUserPassword :: '{}'" , newUserPassword);
//
//            if ((userPhone == null) || "".equals(userPhone) || (newUserPassword == null  || "".equals(newUserPassword))) {
//                return "/membership/modifyPassword";
//            }
//
//            session.invalidate();
//            String newUserPasswordEncryption = EncryptionSHA256.encrypt(newUserPassword);
//
//            userInfo.put("userPhone", userPhone);
//            userInfo.put("newUserPassword", newUserPasswordEncryption);
//
//            service.changeUserPassword(userInfo);
//
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return "redirect:/membership/modifyPasswordSuccess";
//    }
//
//    @GetMapping("modifyPasswordSuccess")
//    public String modifyPasswordSuccess() {
//        return "/membership/modifyPasswordSuccess";
//    }

    // TODO: 2021-01-24 JavaScript 처리 & log 처리

    // TODO: 2021-01-17 POST(저정하고) -> Redirect -> GET(읽어온다) :: 그래야 새로고침시 이슈
    // TODO: 2021-01-17  인터셉터를 이용해서 한번 해봐야 하는데 이해가 안된다...
}
