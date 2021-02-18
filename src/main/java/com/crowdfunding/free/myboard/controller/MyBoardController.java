package com.crowdfunding.free.myboard.controller;

import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.commons.util.PageMaker;
import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.myboard.service.MyBoardService;
import com.crowdfunding.member.entity.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/crowdfunding/free")
public class MyBoardController {

    private static final Logger logger = LoggerFactory.getLogger(MyBoardController.class);

    @Autowired
    private MyBoardService service;

    @GetMapping("/userBoard/myBoardList")
    public String myBoard(@RequestParam(defaultValue = "1") int page, Model model, Criteria criteria, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<>(); // 세션의 userId 와 페이저 정보를 넣는다.
        List<FreeBoardVo> list = new ArrayList<>();
        MemberVo memberVo = new MemberVo();
        PageMaker pageMaker = new PageMaker();
        int countingData = 0;

        memberVo = (MemberVo) session.getAttribute("userInfo");
        String userId = memberVo.getUserId();

        map.put("userId", userId);
        map.put("pageStart", criteria.getPageStart());
        map.put("perPageNum", criteria.getPerPageNum());

        list = service.getMyBoardList(map);
        countingData = service.getMyBoardCountingData(userId);

        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(countingData);

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageMaker);

        return "/free/userBoard/myBoardList";
    }

    @GetMapping("/userBoard/myBoardDetail")
    public String boardDetail(@RequestParam("page") int page, @RequestParam("num") int num,
                              @RequestParam("total") int total, Model model, HttpSession session) throws Exception {
        FreeBoardVo data = new FreeBoardVo();
        MemberVo memberVo = new MemberVo();
        Map<String, Object> map = new HashMap<>();
        String userId = "";

        try {
            memberVo = (MemberVo) session.getAttribute("userInfo");

            userId = memberVo.getUserId();

            map.put("userId", userId);
            map.put("num", num);

            data = service.getMyBoardDetailData(map);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        model.addAttribute("data", data);
        model.addAttribute("page", page);
        model.addAttribute("num", num);
        model.addAttribute("total", total);

        logger.info(data.toString());

        return "/free/userBoard/myBoardDetail";
    }

    @GetMapping("/userBoard/myBoardModify")
    public String modifyPage(@RequestParam("num") int num, Model model, HttpSession session) throws Exception {
        FreeBoardVo data = new FreeBoardVo();
        MemberVo memberVo = new MemberVo();
        Map<String, Object> map = new HashMap<>();
        String userId = "";

        try {
            memberVo = (MemberVo) session.getAttribute("userInfo");

            userId = memberVo.getUserId();

            map.put("userId", userId);
            map.put("num", num);

            data = service.getMyBoardDetailData(map);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("userId", userId);
        model.addAttribute("data", data);
        model.addAttribute("num", num);

        return "/free/userBoard/myBoardModify";
    }

    @PostMapping("/userBoard/myBoardModify")
    public String modifyPost(HttpServletRequest request, Model model) throws Exception {

        Map<String, Object> map = new HashMap<>();
        String title = "";
        String content = "";
        int num = 0;

        try {
            title = request.getParameter("title");
            content = request.getParameter("content");
            num = Integer.parseInt(request.getParameter("num"));

            map.put("title", title);
            map.put("content", content);
            map.put("num", num);

            service.myBoardDataModify(map);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        model.addAttribute("msg", "SUCCESS");

        return "redirect:/crowdfunding/free/board/listPage";
        // TODO: 2021-02-18 myBoardList 게시글이 다르다. 위아래가 어떻게 처리할래? || 게시글 삭제하기
    }
}
