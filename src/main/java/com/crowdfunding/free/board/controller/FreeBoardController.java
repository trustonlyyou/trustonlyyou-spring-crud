package com.crowdfunding.free.board.controller;

import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.commons.util.PageMaker;
import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.board.repository.FreeBoardDao;
import com.crowdfunding.free.board.service.FreeBoardService;
import com.crowdfunding.member.entity.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/crowdfunding/free")
public class FreeBoardController {

    private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

    @Autowired
    FreeBoardService service;

    @GetMapping("/board/listPage")
    public String listPage(@RequestParam(defaultValue = "1") int page, Model model, Criteria criteria) throws Exception {

        List<FreeBoardVo> list = new ArrayList<>();
        PageMaker pageMaker = new PageMaker();
        int countingData = 0;

        try {

            list = service.getBoardList(criteria);
            /**
             * ================default=================
             * criteria.perPageNum = 10; :: 페이지 당 출력되는 게시글의 수
             */
            countingData = service.getCountingData(criteria);

            pageMaker.setCriteria(criteria);
            pageMaker.setTotalCount(countingData);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageMaker);

        return "/free/board/listPage";
    }

    @GetMapping("/board/detail")
    public String boardDetail(@RequestParam("page") int page, @RequestParam("num") int num, HttpServletRequest request, Model model) throws Exception {

        FreeBoardVo data = new FreeBoardVo();
        int maxNum = 0;


        try {
            num = Integer.parseInt(request.getParameter("num"));
            maxNum = service.getMaxNum();
            service.updateViewCnt(num); // 조회수 증가
            data = service.getDetailData(num); // 상세 데이터

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("data", data);
        model.addAttribute("page", page); // 2페이지에서 왔으면 다시 2페이지로 보낼때 사용
        model.addAttribute("num", num); // 이전페이지 다음 페이지 작성 할때 사용
        model.addAttribute("maxNum", maxNum); // 이전페이지 다음 페이지 작성 할때 사용

        logger.info(data.toString());

        return "/free/board/detail";
    }

    @GetMapping("/board/write")
    public String boardWrite(HttpSession session, RedirectAttributes redirectAttributes, Model model) throws Exception {

        MemberVo memberVo = new MemberVo();

        try {
            memberVo = (MemberVo) session.getAttribute("userInfo");

            if (memberVo == null) {
                logger.error("No UserInfo");
                redirectAttributes.addFlashAttribute("msg", "board_login");
                return "redirect:/membership/login";
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("userId", memberVo.getUserId());

        return "/free/board/write";
    }

    @PostMapping("/board/writePost")
    public String boardWrite(@ModelAttribute FreeBoardVo boardVo, Model model, RedirectAttributes redirectAttributes) {

        try {
            service.writeBoard(boardVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/crowdfunding/free/board/listPage";
    }
}

